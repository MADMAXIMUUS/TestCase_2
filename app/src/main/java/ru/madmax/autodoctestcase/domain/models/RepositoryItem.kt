package ru.madmax.autodoctestcase.domain.models

data class RepositoryItem(
    val name: String,
    val lastUpdateDate: String,
    val description: String,
    val star: Int,
    val languages: List<String>,
    val owner_name: String,
    val owner_avatar_url: String
)