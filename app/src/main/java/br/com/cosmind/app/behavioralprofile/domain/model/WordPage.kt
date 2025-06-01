package br.com.cosmind.app.behavioralprofile.domain.model

data class WordPage(
    val words: List<Word>
)

data class Word(
    val type: WordType,
    val name: String
)

enum class WordType {
    A,
    B,
    C,
    D
}