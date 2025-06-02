package br.com.cosmind.app.behavioralprofile.ui.features.history

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import br.com.cosmind.app.behavioralprofile.R
import br.com.cosmind.app.behavioralprofile.ui.theme.BehavioralProfileTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryScreen(
    state: HistoryUiState,
    modifier: Modifier = Modifier,
    handleEvent: (HistoryEvent) -> Unit = {},
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.history_title)
                    )
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
                HistoryUiState.Loading -> {
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
                is HistoryUiState.Success -> {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(
                            state.historyItems,
                            key = {
                                it.id
                            }
                        ) { history ->
                            HistoryItemUi(
                                historyUiItemState = history,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        handleEvent.invoke(HistoryEvent.ClickHistory(history.id))
                                    }
                            )
                        }
                    }
                }
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun HistoryScreenPreview() {
    BehavioralProfileTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.background)
        ) {
            HistoryScreen(
                modifier = Modifier
                    .fillMaxSize(),
                state = HistoryUiState.Loading,
            )
        }
    }
}