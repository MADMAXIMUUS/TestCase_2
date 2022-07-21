package ru.madmax.autodoctestcase.util

import ru.madmax.autodoctestcase.domain.models.Item

class RepositoriesPaginator(
    private val onLoadUpdated: (Boolean) -> Unit,
    private val onRequest: suspend (nextPage: Int) -> Resource<List<Item>>,
    private val onError: suspend (String) -> Unit,
    private val onSuccess: (items: List<Item>) -> Unit
) {

    private var page = 0

    suspend fun loadNextItems() {
        onLoadUpdated(true)
        when(val result = onRequest(page)) {
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