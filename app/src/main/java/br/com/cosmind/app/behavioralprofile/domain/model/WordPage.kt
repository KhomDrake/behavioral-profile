package br.com.cosmind.app.behavioralprofile.domain.model

import androidx.annotation.StringRes

data class WordPage(
    val words: List<Word>
)

data class Word(
    val type: WordType,
    @StringRes
    val name: Int
)

enum class WordType {
    A,
    B,
    C,
    D
}