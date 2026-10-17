package com.ataraxy.app.data.local

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        // Reconstruct quotes table to guarantee FK constraint and all indices are present,
        // regardless of how the v1 table was originally created on this device.
        database.execSQL(
            """
            CREATE TABLE `quotes_new` (
                `id` TEXT NOT NULL,
                `text` TEXT NOT NULL,
                `authorId` TEXT NOT NULL,
                `source` TEXT NOT NULL,
                `virtueId` TEXT NOT NULL,
                `dayOfYear` INTEGER,
                `emotionTag` TEXT,
                PRIMARY KEY(`id`),
                FOREIGN KEY(`authorId`) REFERENCES `authors`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE
            )
            """.trimIndent()
        )
        database.execSQL(
            "INSERT INTO `quotes_new` (`id`, `text`, `authorId`, `source`, `virtueId`, `dayOfYear`, `emotionTag`) " +
            "SELECT `id`, `text`, `authorId`, `source`, `virtueId`, `dayOfYear`, NULL FROM `quotes`"
        )
        database.execSQL("DROP TABLE `quotes`")
        database.execSQL("ALTER TABLE `quotes_new` RENAME TO `quotes`")
        database.execSQL("CREATE INDEX IF NOT EXISTS `index_quotes_authorId` ON `quotes` (`authorId`)")
        database.execSQL("CREATE INDEX IF NOT EXISTS `index_quotes_virtueId` ON `quotes` (`virtueId`)")
        database.execSQL("CREATE INDEX IF NOT EXISTS `index_quotes_dayOfYear` ON `quotes` (`dayOfYear`)")
        database.execSQL("CREATE INDEX IF NOT EXISTS `index_quotes_emotionTag` ON `quotes` (`emotionTag`)")

        database.execSQL("ALTER TABLE journal_entries ADD COLUMN ritualType TEXT")
        database.execSQL(
            """
            CREATE TABLE IF NOT EXISTS control_items (
                id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                text TEXT NOT NULL,
                bucket TEXT,
                actionStep TEXT,
                createdAt TEXT NOT NULL,
                isArchived INTEGER NOT NULL DEFAULT 0
            )
            """.trimIndent()
        )
        database.execSQL(
            """
            CREATE TABLE IF NOT EXISTS sos_events (
                id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                emotion TEXT NOT NULL,
                quoteId TEXT NOT NULL,
                triggeredAt TEXT NOT NULL
            )
            """.trimIndent()
        )
    }
}
