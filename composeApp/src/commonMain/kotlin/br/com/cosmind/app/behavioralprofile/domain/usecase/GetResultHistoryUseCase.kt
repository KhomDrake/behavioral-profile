package br.com.cosmind.app.behavioralprofile.domain.usecase

import br.com.cosmind.app.behavioralprofile.domain.repository.ResultRepository

class GetResultHistoryUseCase(
    private val resultRepository: ResultRepository
) {

    suspend fun invoke() = resultRepository.getAllResults()

    suspend fun invoke(id: Long) = resultRepository.getAllResults().first { it.id == id }

}