package br.com.cosmind.app.behavioralprofile.data

import br.com.cosmind.app.behavioralprofile.domain.model.Word
import br.com.cosmind.app.behavioralprofile.domain.model.WordPage
import br.com.cosmind.app.behavioralprofile.domain.model.WordType
import br.com.cosmind.app.behavioralprofile.domain.repository.WordRepository

class WordRepositoryImpl: WordRepository {

    override suspend fun getWordsPage(): List<WordPage> {
        return listOf(
            WordPage(
                words = listOf(
                    Word(
                        type = WordType.A,
                        name = "Creation"
                    )
                )
            )
        )
    }

}