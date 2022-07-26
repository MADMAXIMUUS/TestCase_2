package ru.madmax.autodoctestcase.data.repository

import okio.IOException
import retrofit2.HttpException
import ru.madmax.autodoctestcase.data.remote.GitHubApi
import ru.madmax.autodoctestcase.domain.models.OwnerDetails
import ru.madmax.autodoctestcase.domain.models.RepositoryItem
import ru.madmax.autodoctestcase.domain.repository.GitHubRepository
import ru.madmax.autodoctestcase.util.Resource

class GitHubRepositoryImpl(
    private val gitHubApi: GitHubApi
) : GitHubRepository {

    override suspend fun getRepositories(
        query: String,
        page: Int,
        perPage: Int
    ): Resource<List<RepositoryItem>> {
        return try {
            val response = gitHubApi.search(query, page, perPage)
            val list: MutableList<RepositoryItem> = mutableListOf()
            if (response.items.isNotEmpty()) {
                response.items.forEach {
                    val languages =
                        gitHubApi.getLanguages(it.owner?.login.toString(), it.name.toString())
                    list.add(it.toRepositoryItem(languages.keySet().toList()))
                }
                Resource.Success(list)
            } else {
                Resource.Error("Ошибка")
            }
        } catch (e: IOException) {
            Resource.Error("Ой, что-то пошло не так. Проверьте подключение к интернету")
        } catch (e: HttpException) {
            Resource.Error("Мы пытались, но что-то пошло не так. Обновите страницу")
        }
    }

    override suspend fun getUser(username: String): Resource<OwnerDetails> {
        return try {
            val response = gitHubApi.getUser(username)
            if (response.login.toString().isNotEmpty()) {
                Resource.Success(response.toOwnerDetails())
            } else {
                Resource.Error("Ошибка")
            }
        } catch (e: IOException) {
            Resource.Error("Ой, что-то пошло не так. Проверьте подключение к интернету")
        } catch (e: HttpException) {
            Resource.Error("Мы пытались, но что-то пошло не так. Обновите страницу")
        }
    }

}