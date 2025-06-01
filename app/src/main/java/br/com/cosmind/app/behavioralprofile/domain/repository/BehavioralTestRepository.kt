package br.com.cosmind.app.behavioralprofile.domain.repository

import br.com.cosmind.app.behavioralprofile.domain.model.ResultModel
import br.com.cosmind.app.behavioralprofile.domain.model.Word
import br.com.cosmind.app.behavioralprofile.domain.model.WordPage

interface BehavioralTestRepository {

    fun startTest(words: List<WordPage>)

    fun selectWord(word: Word)

    suspend fun nextPage(): WordPage?

    suspend fun finishTest(): ResultModel

    suspend fun isFinished(): Boolean

}