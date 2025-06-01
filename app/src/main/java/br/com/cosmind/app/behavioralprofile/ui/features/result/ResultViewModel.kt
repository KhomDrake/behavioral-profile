package br.com.cosmind.app.behavioralprofile.ui.features.result

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.cosmind.app.behavioralprofile.domain.model.ResultModel
import br.com.cosmind.app.behavioralprofile.domain.model.WordType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

sealed interface ResultUiState {
    data class Success(
        val selectedWordType: SnapshotStateList<WordTypeUiState>,
        val missed: Int,
    ): ResultUiState {

        data class WordTypeUiState(
            val selected: Int,
            val percentage: Int,
            val wordType: WordType
        )
    }

    data object Loading: ResultUiState
}

class ResultViewModel: ViewModel() {

    private var _state = MutableStateFlow<ResultUiState>(ResultUiState.Loading)

    val state: StateFlow<ResultUiState>
        get() = _state.asStateFlow()

    fun setResult(resultModel: ResultModel) {
        viewModelScope.launch {
            _state.update {
                ResultUiState.Loading
            }

            val selectedWords = listOf(
                ResultUiState.Success.WordTypeUiState(
                    selected = resultModel.quantityA,
                    percentage = (resultModel.quantityA / resultModel.total.toFloat()).times(100).toInt(),
                    wordType = WordType.A
                ),
                ResultUiState.Success.WordTypeUiState(
                    selected = resultModel.quantityB,
                    percentage = (resultModel.quantityB / resultModel.total.toFloat()).times(100).toInt(),
                    wordType = WordType.B
                ),
                ResultUiState.Success.WordTypeUiState(
                    selected = resultModel.quantityC,
                    percentage = (resultModel.quantityC / resultModel.total.toFloat()).times(100).toInt(),
                    wordType = WordType.C
                ),
                ResultUiState.Success.WordTypeUiState(
                    selected = resultModel.quantityD,
                    percentage = (resultModel.quantityD / resultModel.total.toFloat()).times(100).toInt(),
                    wordType = WordType.D
                ),
            )
                .sortedByDescending { it.selected }
                .toMutableStateList()

            val success = ResultUiState.Success(
                selectedWordType = selectedWords,
                missed = resultModel.missed
            )

            _state.update {
                success
            }
        }
    }

}