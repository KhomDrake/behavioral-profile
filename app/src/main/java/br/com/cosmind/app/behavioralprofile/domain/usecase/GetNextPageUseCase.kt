package br.com.cosmind.app.behavioralprofile.domain.usecase

import br.com.cosmind.app.behavioralprofile.domain.model.WordPage
import br.com.cosmind.app.behavioralprofile.domain.repository.BehavioralTestRepository

class GetNextPageUseCase(
    private val repository: BehavioralTestRepository
) {

    suspend fun invoke(): WordPage? {
        return repository.nextPage()
    }

}