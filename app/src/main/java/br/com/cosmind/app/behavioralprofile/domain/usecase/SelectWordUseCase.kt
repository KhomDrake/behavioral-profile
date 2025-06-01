package br.com.cosmind.app.behavioralprofile.domain.usecase

import br.com.cosmind.app.behavioralprofile.domain.model.Word
import br.com.cosmind.app.behavioralprofile.domain.model.WordType
import br.com.cosmind.app.behavioralprofile.domain.repository.BehavioralTestRepository

class SelectWordUseCase(
    private val repository: BehavioralTestRepository
) {

    suspend fun invoke(wordType: WordType) {
        repository.selectWord(
            Word(
                name = 0,
                type = wordType
            )
        )
    }

}