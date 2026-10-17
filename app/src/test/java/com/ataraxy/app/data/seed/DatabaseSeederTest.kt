package com.ataraxy.app.data.seed

import com.ataraxy.app.data.local.AtaraxyDatabase
import com.ataraxy.app.data.local.inMemoryDatabase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class DatabaseSeederTest {

    private lateinit var db: AtaraxyDatabase
    private lateinit var seeder: DatabaseSeeder

    private val expectedDailyQuotes = QuoteData.quotes.count { it.dayOfYear != null }

    @Before
    fun setUp() {
        db = inMemoryDatabase()
        seeder = DatabaseSeeder(db)
    }

    @After
    fun tearDown() = db.close()

    @Test
    fun seed_restoresQuotes_whenEarlierSeedStoppedAfterVirtues() = runBlocking {
        db.authorDao().insertAuthors(AuthorData.authors)
        db.virtueDao().insertVirtues(VirtueData.virtues)
        db.virtueDao().insertSubConcepts(VirtueData.subConcepts)

        seeder.seed()

        assertEquals(expectedDailyQuotes, db.quoteDao().observeDailyQuoteCount().first())
        assertEquals(QuoteData.quotes.size, db.quoteDao().count())
    }

    @Test
    fun seed_isIdempotent() = runBlocking {
        seeder.seed()
        seeder.seed()

        assertEquals(QuoteData.quotes.size, db.quoteDao().count())
        assertEquals(AuthorData.authors.size, db.authorDao().count())
        assertEquals(VirtueData.virtues.size, db.virtueDao().count())
    }
}
