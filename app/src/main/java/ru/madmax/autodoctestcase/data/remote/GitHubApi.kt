package ru.madmax.autodoctestcase.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.madmax.autodoctestcase.domain.models.Item
import ru.madmax.autodoctestcase.domain.models.Response
import ru.madmax.autodoctestcase.domain.models.User

interface GitHubApi {

    @GET("search/repositories")
    suspend fun search(
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Response

    @GET("users/{username}")
    suspend fun getUser(
        @Path("username") username: String
    ): User

    companion object {
        const val BASE_URL = "https://api.github.com/"
    }
}