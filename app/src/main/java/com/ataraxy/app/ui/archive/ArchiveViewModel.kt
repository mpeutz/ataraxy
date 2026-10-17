package com.ataraxy.app.ui.archive

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ataraxy.app.data.repository.QuoteRepository
import com.ataraxy.app.data.repository.VirtueRepository
import com.ataraxy.app.domain.model.Author
import com.ataraxy.app.domain.model.Quote
import com.ataraxy.app.domain.model.Virtue
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import com.ataraxy.app.data.local.dao.AuthorDao

@HiltViewModel
class ArchiveViewModel @Inject constructor(
    private val quoteRepository: QuoteRepository,
    virtueRepository: VirtueRepository,
    authorDao: AuthorDao
) : ViewModel() {

    val searchQuery = MutableStateFlow("")
    val selectedAuthorId = MutableStateFlow<String?>(null)
    val showBookmarkedOnly = MutableStateFlow(false)

    val virtues: StateFlow<List<Virtue>> = virtueRepository.getAllVirtues()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    val authors: StateFlow<List<Author>> = authorDao.getAllAuthors()
        .map { list ->
            list.map {
                Author(
                    id = it.id,
                    name = it.name,
                    bio = it.bio,
                    era = it.era,
                    school = it.school
                )
            }
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    @OptIn(ExperimentalCoroutinesApi::class)
    val quotes: StateFlow<List<Quote>> = combine(
        searchQuery,
        selectedAuthorId,
        showBookmarkedOnly
    ) { query, author, bookmarked ->
        Triple(query, author, bookmarked)
    }.flatMapLatest { (query, authorId, bookmarked) ->
        when {
            bookmarked -> quoteRepository.getBookmarkedQuotes()
            query.isNotBlank() -> quoteRepository.searchQuotes(query)
            authorId != null -> quoteRepository.getQuotesByAuthor(authorId)
            else -> quoteRepository.getAllQuotes().map { list ->
                // Daily-stable shuffle: same order all day, changes each day
                val seed = java.time.LocalDate.now().toEpochDay()
                list.shuffled(java.util.Random(seed))
            }
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    val featuredQuote: StateFlow<Quote?> = quoteRepository.getAllQuotes()
        .map { list ->
            if (list.isEmpty()) null
            else {
                val idx = java.time.LocalDate.now().dayOfYear % list.size
                list[idx]
            }
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), null)

    fun search(query: String) { searchQuery.value = query }
    fun filterByAuthor(authorId: String?) {
        selectedAuthorId.value = authorId
        showBookmarkedOnly.value = false
    }
    fun showBookmarked() {
        showBookmarkedOnly.value = true
        selectedAuthorId.value = null
    }
}
