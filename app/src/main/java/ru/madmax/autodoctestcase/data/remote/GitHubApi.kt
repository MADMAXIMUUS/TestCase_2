package ru.madmax.autodoctestcase.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.madmax.autodoctestcase.domain.models.Item

interface GitHubApi {

    @GET("search/repositories")
    suspend fun search(
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("per_page") pageSize: Int
    ): List<Item>

    @GET("users/{username}")
    suspend fun getUser(
        @Path("username") username: String
    )

    companion object {
        const val BASE_URL = "https://api.github.com/"
    }
}