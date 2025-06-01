package br.com.cosmind.app.behavioralprofile.ui.features.test

import androidx.compose.runtime.snapshots.SnapshotStateList

data class TestUiState(
    val words: SnapshotStateList<WordUi>,
    val timeProgress: Float = 0.0f,
) {
    data class WordUi(
        val name: String,
        val letter: String
    )
}