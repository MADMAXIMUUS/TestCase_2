package ru.madmax.autodoctestcase.domain.repository

import ru.madmax.autodoctestcase.domain.models.Item
import ru.madmax.autodoctestcase.domain.models.Response
import ru.madmax.autodoctestcase.domain.models.User
import ru.madmax.autodoctestcase.util.Resource

interface GitHubRepository {

    suspend fun getRepositories(
        query: String,
        page: Int,
        perPage: Int
    ): Resource<List<Item>>

    suspend fun getUser(
        username: String
    ): Resource<User>

}