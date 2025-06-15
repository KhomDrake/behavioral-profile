package br.com.cosmind.app.behavioralprofile.domain.model

import org.jetbrains.compose.resources.StringResource

data class WordPage(
    val words: List<Word>
)

data class Word(
    val type: WordType,
    val name: StringResource
)

enum class WordType {
    A,
    B,
    C,
    D
}