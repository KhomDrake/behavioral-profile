package br.com.cosmind.app.behavioralprofile.ui.features.result

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import br.com.cosmind.app.behavioralprofile.R
import br.com.cosmind.app.behavioralprofile.domain.model.WordType
import br.com.cosmind.app.behavioralprofile.ui.theme.BehavioralProfileTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultScreen(
    state: ResultUiState,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.behavioral_profile_result)
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            onBackClick.invoke()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) {
        AnimatedContent(
            state,
            modifier = Modifier
                .padding(it)
        ) { state ->
            when(state) {
                ResultUiState.Loading -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .align(Alignment.Center),
                            strokeWidth = 2.dp
                        )
                    }
                }
                is ResultUiState.Success -> {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        if(state.missed > 0) {
                            item(key = "Missed Text") {
                                Text(
                                    stringResource(R.string.missed_text, state.missed),
                                    color = MaterialTheme.colorScheme.onBackground,
                                    style = MaterialTheme.typography.titleLarge
                                )
                            }
                        }


                        items(state.selectedWordType, key = { it.wordType }) { wordTypeUiState ->
                            WordTypeUi(
                                wordTypeUiState = wordTypeUiState,
                                modifier = Modifier
                                    .fillMaxWidth()
                            )
                        }
                    }
                }
            }
        }
    }

}

class ResultScreenPreviewProvider: PreviewParameterProvider<ResultUiState> {

    override val values: Sequence<ResultUiState>
        get() = listOf(
            ResultUiState.Loading,
            ResultUiState.Success(
                selectedWordType = mutableStateListOf(
                    ResultUiState.Success.WordTypeUiState(
                        5,
                        20,
                        wordType = WordType.A
                    )
                ),
                missed = 0
            )
        )
            .asSequence()

}

@PreviewLightDark
@Composable
private fun ResultScreenPreview(
    @PreviewParameter(ResultScreenPreviewProvider::class)
    state: ResultUiState
) {
    BehavioralProfileTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            ResultScreen(
                state,
                modifier = Modifier
                    .fillMaxSize()
            )
        }

    }
}