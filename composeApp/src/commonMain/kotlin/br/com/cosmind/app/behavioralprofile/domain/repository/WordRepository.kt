package br.com.cosmind.app.behavioralprofile.domain.repository

import br.com.cosmind.app.behavioralprofile.domain.model.WordPage

interface WordRepository {

    suspend fun getWordsPage(): List<WordPage>

}