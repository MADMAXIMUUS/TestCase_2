package ru.madmax.autodoctestcase.data.remote

import com.google.gson.JsonObject
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

    @GET("repos/{owner}/{repos}/languages")
    suspend fun getLanguages(
        @Path("owner") name: String,
        @Path("repos") repos: String
    ): JsonObject

    companion object {
        const val BASE_URL = "https://api.github.com/"
    }
}