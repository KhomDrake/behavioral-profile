package br.com.cosmind.app.behavioralprofile.ui.features.test

import androidx.compose.runtime.snapshots.SnapshotStateList
import br.com.cosmind.app.behavioralprofile.domain.model.ResultModel
import br.com.cosmind.app.behavioralprofile.domain.model.WordType
import org.jetbrains.compose.resources.StringResource

data class TestUiState(
    val words: SnapshotStateList<WordUi>,
    val timeProgress: Float = 0.0f,
    val resultModel: ResultModel? = null
) {
    data class WordUi(
        val name: StringResource,
        val wordType: WordType = WordType.A
    )
}

sealed class TestUiEvent {

    data class SelectWord(val word: TestUiState.WordUi) : TestUiEvent()

}