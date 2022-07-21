package ru.madmax.autodoctestcase.domain.use_case

import ru.madmax.autodoctestcase.domain.repository.GitHubRepository


class GetRepositoriesUseCase(
    private val gitHubRepository: GitHubRepository
) {
    suspend operator fun invoke(
        query: String,
        page: Int,
        perPage: Int
    ) = gitHubRepository.getRepositories(query, page, perPage)
}