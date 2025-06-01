package br.com.cosmind.app.behavioralprofile.data.repository

import br.com.cosmind.app.behavioralprofile.data.database.BehavioralDao
import br.com.cosmind.app.behavioralprofile.data.database.entity.BehavioralTestResultEntity
import br.com.cosmind.app.behavioralprofile.domain.model.Word
import br.com.cosmind.app.behavioralprofile.domain.model.WordPage
import br.com.cosmind.app.behavioralprofile.domain.model.WordType
import br.com.cosmind.app.behavioralprofile.domain.repository.BehavioralTestRepository
import java.time.LocalDateTime

class BehavioralTestRepositoryImpl(
    private val dao: BehavioralDao
): BehavioralTestRepository {

    private var maxWords = 25

    private var currentPage = 0
    private var pages: List<WordPage> = listOf()

    private var selectedWords: MutableList<Word> = mutableListOf()

    override fun startTest(words: List<WordPage>) {
        pages = words
        selectedWords.clear()
    }

    override fun selectWord(word: Word) {
        selectedWords.add(word)
    }

    override suspend fun finishTest() {
        val selectedByGroup = selectedWords.groupingBy { it.type }
            .eachCount()

        val resultEntity = BehavioralTestResultEntity(
            name = null,
            date = LocalDateTime.now().toString(),
            selectedA = selectedByGroup[WordType.A] ?: 0,
            selectedB = selectedByGroup[WordType.B] ?: 0,
            selectedC = selectedByGroup[WordType.C] ?: 0,
            selectedD = selectedByGroup[WordType.D] ?: 0
        )

        dao.insertResult(
            resultEntity
        )
    }

    override suspend fun isFinished(): Boolean {
        return selectedWords.size == maxWords
    }

    override suspend fun nextPage(): WordPage? {
        val page = pages.getOrNull(currentPage)
        currentPage++
        return page
    }
}