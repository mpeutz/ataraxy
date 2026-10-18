package com.ataraxy.app.data.seed

import androidx.room.withTransaction
import com.ataraxy.app.data.local.AtaraxyDatabase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DatabaseSeeder @Inject constructor(
    private val db: AtaraxyDatabase
) {
    /**
     * Inserts all seed data in one transaction, so running this on each launch repairs an
     * interrupted seed and backfills rows added in later releases. Quotes are upserted so
     * corrected wording reaches existing installs; other rows ignore existing entries.
     */
    suspend fun seed() {
        db.withTransaction {
            db.authorDao().insertAuthors(AuthorData.authors)
            db.virtueDao().insertVirtues(VirtueData.virtues)
            db.virtueDao().insertSubConcepts(VirtueData.subConcepts)
            db.quoteDao().insertQuotes(QuoteData.quotes)
        }
    }
}
