package br.com.cosmind.app.behavioralprofile.ui.features.history

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.cosmind.app.behavioralprofile.domain.usecase.GetResultHistoryUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

class HistoryViewModel(
    private val getHistoryUseCase: GetResultHistoryUseCase
): ViewModel() {

    private val _state = MutableStateFlow<HistoryUiState>(HistoryUiState.Loading)

    val state = _state.asStateFlow()

    fun handleEvent(event: HistoryEvent) {
        when(event) {
            HistoryEvent.RestNavigation -> {
                _state.update {
                    when(it) {
                        HistoryUiState.Loading -> HistoryUiState.Loading
                        is HistoryUiState.Success -> it.copy(goToResult = null)
                    }
                }
            }
            is HistoryEvent.ClickHistory -> {
                viewModelScope.launch {
                    val history = getHistoryUseCase.invoke(event.id)

                    _state.update {
                        when(it) {
                            HistoryUiState.Loading -> HistoryUiState.Loading
                            is HistoryUiState.Success -> it.copy(goToResult = history)
                        }
                    }
                }
            }
        }
    }

    fun loadHistory() {
        viewModelScope.launch {
            _state.update {
                HistoryUiState.Loading
            }
            runCatching {
                val results = withContext(Dispatchers.IO) {
                    getHistoryUseCase.invoke()
                }

                _state.update {
                    HistoryUiState.Success(
                        results.map { result ->
                            HistoryUiItemState(
                                date = LocalDateTime.parse(
                                    result.date
                                )
                                    .format(
                                        DateTimeFormatter.ofPattern("MMMM dd, yyyy", Locale.getDefault())
                                    ),
                                highest = result.highest,
                                id = result.id
                            )
                        }.toMutableStateList()
                    )
                }
            }
        }

    }

}