package br.com.cosmind.app.behavioralprofile.ui.features.test

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.cosmind.app.behavioralprofile.domain.model.WordPage
import br.com.cosmind.app.behavioralprofile.domain.usecase.GetRandomWordPagesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TestViewModel(
    private val getRandomWordPagesUseCase: GetRandomWordPagesUseCase
): ViewModel() {

    private var currentWordPage: Int = 0
    private var shuffledWordPages = listOf<WordPage>()

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

    fun handleEvent() {

    }

    private fun startTest() {
        viewModelScope.launch {
            shuffledWordPages = getRandomWordPagesUseCase.invoke()
            loadPage()
        }
    }

    private fun loadPage() {

    }

}