package ru.madmax.autodoctestcase.domain.models

data class Response(
    val incomplete_results: Boolean,
    val items: List<Item>,
    val total_count: Int
)