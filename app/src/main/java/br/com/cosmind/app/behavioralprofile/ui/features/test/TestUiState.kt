package br.com.cosmind.app.behavioralprofile.ui.features.test

import androidx.annotation.StringRes
import androidx.compose.runtime.snapshots.SnapshotStateList
import br.com.cosmind.app.behavioralprofile.domain.model.WordType

data class TestUiState(
    val words: SnapshotStateList<WordUi>,
    val timeProgress: Float = 0.0f,
) {
    data class WordUi(
        @StringRes
        val name: Int,
        val wordType: WordType = WordType.A
    )
}

sealed class TestUiEvent {

    data class SelectWord(val word: TestUiState.WordUi) : TestUiEvent()

}