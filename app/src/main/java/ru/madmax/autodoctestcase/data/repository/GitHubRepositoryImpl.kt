package ru.madmax.autodoctestcase.data.repository

import okio.IOException
import retrofit2.HttpException
import ru.madmax.autodoctestcase.data.remote.GitHubApi
import ru.madmax.autodoctestcase.domain.models.Item
import ru.madmax.autodoctestcase.domain.models.User
import ru.madmax.autodoctestcase.domain.repository.GitHubRepository
import ru.madmax.autodoctestcase.util.Resource

class GitHubRepositoryImpl(
    private val gitHubApi: GitHubApi
) : GitHubRepository {

    override suspend fun getRepositories(
        query: String,
        page: Int,
        perPage: Int
    ): Resource<List<Item>> {
        return try {
            val response = gitHubApi.search(query, page, perPage)
            if (response.items.isNotEmpty()) {
                Resource.Success(response.items)
            } else {
                Resource.Error("Ошибка")
            }
        } catch (e: IOException) {
            Resource.Error("Ой, что-то пошло не так. Проверьте подключение к интернету")
        } catch (e: HttpException) {
            Resource.Error("Мы пытались, но что-то пошло не так. Обновите страницу")
        }
    }

    override suspend fun getUser(username: String): Resource<User> {
        return try {
            val response = gitHubApi.getUser(username)
            if (response.login.isNotEmpty()) {
                Resource.Success(response)
            } else {
                Resource.Error("Ошибка")
            }
        }
        catch (e: IOException) {
            Resource.Error("Ой, что-то пошло не так. Проверьте подключение к интернету")
        } catch (e: HttpException) {
            Resource.Error("Мы пытались, но что-то пошло не так. Обновите страницу")
        }
    }

}