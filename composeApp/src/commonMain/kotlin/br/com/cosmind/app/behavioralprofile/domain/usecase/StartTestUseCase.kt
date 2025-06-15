package br.com.cosmind.app.behavioralprofile.domain.usecase

import br.com.cosmind.app.behavioralprofile.domain.repository.BehavioralTestRepository
import br.com.cosmind.app.behavioralprofile.domain.repository.WordRepository

class StartTestUseCase(
    private val repository: BehavioralTestRepository,
    private val wordRepository: WordRepository
) {

    suspend fun invoke() {
        repository.startTest(
            words = wordRepository.getWordsPage().shuffled()
        )
    }

}