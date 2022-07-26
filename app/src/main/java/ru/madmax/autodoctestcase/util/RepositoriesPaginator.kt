package ru.madmax.autodoctestcase.util

import ru.madmax.autodoctestcase.domain.models.RepositoryItem

class RepositoriesPaginator(
    private val onLoadUpdated: (Boolean) -> Unit,
    private val onRequest: suspend (nextPage: Int) -> Resource<List<RepositoryItem>>,
    private val onError: suspend (String) -> Unit,
    private val onSuccess: (items: List<RepositoryItem>) -> Unit,
    private val onRefresh: (items: List<RepositoryItem>) -> Unit
) {

    private var page = 1

    suspend fun refresh() {
        onLoadUpdated(true)
        page = 1
        when (val result = onRequest(page)) {
            is Resource.Success -> {
                val items = result.data ?: emptyList()
                onRefresh(items)
                onLoadUpdated(false)
            }
            is Resource.Error -> {
                onError(result.message ?: "Неизвестная ошибка")
                onLoadUpdated(false)
            }
        }
    }

    suspend fun loadNextItems() {
        onLoadUpdated(true)
        when (val result = onRequest(page)) {
            is Resource.Success -> {
                val items = result.data ?: emptyList()
                page++
                onSuccess(items)
                onLoadUpdated(false)
            }
            is Resource.Error -> {
                onError(result.message ?: "Неизвестная ошибка")
                onLoadUpdated(false)
            }
        }
    }
}