package ru.madmax.autodoctestcase.domain.use_case

import ru.madmax.autodoctestcase.domain.repository.GitHubRepository

class GetUserUseCase(
    private val gitHubRepository: GitHubRepository
) {
    suspend operator fun invoke(username: String) = gitHubRepository.getUser(username)
}