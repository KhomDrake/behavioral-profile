package br.com.cosmind.app.behavioralprofile.ui.features.history

import androidx.compose.runtime.snapshots.SnapshotStateList
import br.com.cosmind.app.behavioralprofile.domain.model.ResultModel
import br.com.cosmind.app.behavioralprofile.domain.model.WordType

sealed interface HistoryUiState {

    data object Loading: HistoryUiState

    data class Success(
        val historyItems: SnapshotStateList<HistoryUiItemState>,
        val goToResult: ResultModel? = null,
    ): HistoryUiState

}

data class HistoryUiItemState(
    val id: Long,
    val date: String,
    val highest: WordType
)

sealed interface HistoryEvent {
    data class ClickHistory(val id: Long): HistoryEvent

    data object RestNavigation: HistoryEvent
}