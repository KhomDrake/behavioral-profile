package br.com.cosmind.app.behavioralprofile.ui.features.test

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.cosmind.app.behavioralprofile.domain.usecase.FinishTestUseCase
import br.com.cosmind.app.behavioralprofile.domain.usecase.GetNextPageUseCase
import br.com.cosmind.app.behavioralprofile.domain.usecase.SelectWordUseCase
import br.com.cosmind.app.behavioralprofile.domain.usecase.StartTestUseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

class TestViewModel(
    private val startTestUseCase: StartTestUseCase,
    private val finishTestUseCase: FinishTestUseCase,
    private val selectWordUseCase: SelectWordUseCase,
    private val getNextPageUseCase: GetNextPageUseCase
): ViewModel() {

    private var timeJob: Job? = null
    private val _state = MutableStateFlow(
        TestUiState(
            words = listOf<TestUiState.WordUi>().toMutableStateList(),
            timeProgress = 0.0f
        )
    )

    val state: StateFlow<TestUiState>
        get() = _state.asStateFlow()

    init {
        startTest()
    }

    fun handleEvent(event: TestUiEvent) {
        when(event) {
            is TestUiEvent.SelectWord -> {
                selectWord(event.word)
            }
        }
    }

    private fun startTest() {
        viewModelScope.launch {
            startTestUseCase.invoke()
            loadNextPage()
        }
    }

    private fun loadNextPage() {
        timeJob?.cancel()
        timeJob = viewModelScope.launch {
            val page = getNextPageUseCase.invoke() ?: return@launch run {
                finishTestUseCase.invoke()

            }

            val words = page.words.map { word ->
                TestUiState.WordUi(
                    wordType = word.type,
                    name = word.name
                )
            }?.toMutableStateList() ?: mutableStateListOf()

            _state.update {
                it.copy(
                    timeProgress = 0.0f,
                    words = words
                )
            }

            var finishTime = System.currentTimeMillis() + 5.seconds.inWholeSeconds

            while (System.currentTimeMillis() < finishTime && isActive) {
                val progress = (finishTime - System.currentTimeMillis())/5.seconds.inWholeSeconds
                delay(100)
                _state.update {
                    it.copy(
                        timeProgress = progress.toFloat()
                    )
                }
            }

            if(isActive) {
                loadNextPage()
            }
        }
    }

    private fun selectWord(word: TestUiState.WordUi) {
        viewModelScope.launch {
            timeJob?.cancel()
            selectWordUseCase.invoke(wordType = word.wordType)
            loadNextPage()
        }

    }

}