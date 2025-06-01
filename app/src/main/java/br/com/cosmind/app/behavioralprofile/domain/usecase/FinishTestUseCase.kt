package br.com.cosmind.app.behavioralprofile.domain.usecase

import br.com.cosmind.app.behavioralprofile.domain.repository.BehavioralTestRepository

class FinishTestUseCase(
    private val repository: BehavioralTestRepository
) {

    suspend fun invoke() {
        repository.finishTest()
    }
}