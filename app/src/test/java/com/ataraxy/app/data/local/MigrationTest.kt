package com.ataraxy.app.data.local

import android.content.Context
import androidx.room.Room
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory
import androidx.test.core.app.ApplicationProvider
import org.json.JSONObject
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.io.File

/**
 * Builds an old database straight from its exported schema, then opens the current one with the
 * real migrations. Room validates the migrated schema against the current entities on open.
 * (Room 2.8's MigrationTestHelper rejects Windows database paths, so it is not used here.)
 */
@RunWith(RobolectricTestRunner::class)
class MigrationTest {

    private val context: Context = ApplicationProvider.getApplicationContext()

    @After
    fun tearDown() {
        context.deleteDatabase(DB_NAME)
    }

    @Test
    fun migrate2To3_dropsControlItems_createsReflectionTables() {
        createDatabaseFromSchema(version = 2).apply {
            execSQL(
                "INSERT INTO control_items (text, bucket, actionStep, createdAt, isArchived) " +
                    "VALUES ('Traffic', 'NOT_IN_CONTROL', NULL, '2026-10-01T08:00', 1)"
            )
            close()
        }

        val db = Room.databaseBuilder(context, AtaraxyDatabase::class.java, DB_NAME)
            .addMigrations(MIGRATION_1_2, MIGRATION_2_3)
            .allowMainThreadQueries()
            .build()
        val sql = db.openHelper.writableDatabase

        sql.query("SELECT name FROM sqlite_master WHERE type = 'table' AND name = 'control_items'").use {
            assertFalse(it.moveToFirst())
        }
        sql.execSQL("INSERT INTO reflections (worry, createdAt) VALUES ('Job interview', '2026-10-18T09:00')")
        sql.execSQL(
            "INSERT INTO reflection_notes (reflectionId, text, createdAt) " +
                "VALUES (1, 'Practiced twice', '2026-10-19T09:00')"
        )
        sql.query("SELECT COUNT(*) FROM reflection_notes").use {
            it.moveToFirst()
            assertEquals(1, it.getInt(0))
        }
        db.close()
    }

    private fun createDatabaseFromSchema(version: Int): SupportSQLiteDatabase {
        val schema = JSONObject(File(SCHEMA_DIR, "$version.json").readText()).getJSONObject("database")
        val callback = object : SupportSQLiteOpenHelper.Callback(version) {
            override fun onCreate(db: SupportSQLiteDatabase) {
                val entities = schema.getJSONArray("entities")
                for (i in 0 until entities.length()) {
                    val entity = entities.getJSONObject(i)
                    val table = entity.getString("tableName")
                    db.execSQL(entity.getString("createSql").replace("\${TABLE_NAME}", table))
                    val indices = entity.optJSONArray("indices") ?: continue
                    for (j in 0 until indices.length()) {
                        db.execSQL(indices.getJSONObject(j).getString("createSql").replace("\${TABLE_NAME}", table))
                    }
                }
                val setup = schema.getJSONArray("setupQueries")
                for (i in 0 until setup.length()) db.execSQL(setup.getString(i))
            }

            override fun onUpgrade(db: SupportSQLiteDatabase, oldVersion: Int, newVersion: Int) = Unit
        }
        val config = SupportSQLiteOpenHelper.Configuration.builder(context).name(DB_NAME).callback(callback).build()
        return FrameworkSQLiteOpenHelperFactory().create(config).writableDatabase
    }

    private companion object {
        const val DB_NAME = "migration-test.db"
        const val SCHEMA_DIR = "schemas/com.ataraxy.app.data.local.AtaraxyDatabase"
    }
}
