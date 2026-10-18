package com.ataraxy.app.data.local

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(db: SupportSQLiteDatabase) {
        // Reconstruct quotes table to guarantee FK constraint and all indices are present,
        // regardless of how the v1 table was originally created on this device.
        db.execSQL(
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
        db.execSQL(
            "INSERT INTO `quotes_new` (`id`, `text`, `authorId`, `source`, `virtueId`, `dayOfYear`, `emotionTag`) " +
            "SELECT `id`, `text`, `authorId`, `source`, `virtueId`, `dayOfYear`, NULL FROM `quotes`"
        )
        db.execSQL("DROP TABLE `quotes`")
        db.execSQL("ALTER TABLE `quotes_new` RENAME TO `quotes`")
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_quotes_authorId` ON `quotes` (`authorId`)")
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_quotes_virtueId` ON `quotes` (`virtueId`)")
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_quotes_dayOfYear` ON `quotes` (`dayOfYear`)")
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_quotes_emotionTag` ON `quotes` (`emotionTag`)")

        db.execSQL("ALTER TABLE journal_entries ADD COLUMN ritualType TEXT")
        db.execSQL(
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
        db.execSQL(
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
