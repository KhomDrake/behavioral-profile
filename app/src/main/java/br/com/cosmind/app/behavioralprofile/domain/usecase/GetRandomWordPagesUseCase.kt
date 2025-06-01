package br.com.cosmind.app.behavioralprofile.domain.usecase

import br.com.cosmind.app.behavioralprofile.domain.model.WordPage
import br.com.cosmind.app.behavioralprofile.domain.repository.WordRepository

class GetRandomWordPagesUseCase(
    private val repository: WordRepository
) {

    suspend fun invoke(): List<WordPage> {
        return repository.getWordsPage().shuffled()
    }

}