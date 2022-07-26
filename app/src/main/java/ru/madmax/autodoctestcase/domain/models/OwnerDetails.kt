package ru.madmax.autodoctestcase.domain.models

data class OwnerDetails(
    val avatar_url: String = "",
    val bio: String = "",
    val followers: Int = 0,
    val following: Int = 0,
    val login: String = "",
    val twitter_username: String = "",
    val blog: String = ""
)