package br.com.cosmind.app.behavioralprofile.domain.usecase

import behavioral_profile.composeapp.generated.resources.Res
import behavioral_profile.composeapp.generated.resources.app_name
import br.com.cosmind.app.behavioralprofile.domain.model.Word
import br.com.cosmind.app.behavioralprofile.domain.model.WordType
import br.com.cosmind.app.behavioralprofile.domain.repository.BehavioralTestRepository

class SelectWordUseCase(
    private val repository: BehavioralTestRepository
) {

    suspend fun invoke(wordType: WordType) {
        repository.selectWord(
            Word(
                name = Res.string.app_name,
                type = wordType
            )
        )
    }

}