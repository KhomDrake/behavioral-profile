package br.com.cosmind.app.behavioralprofile.ui.features.test

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import br.com.cosmind.app.behavioralprofile.R
import br.com.cosmind.app.behavioralprofile.ui.theme.BehavioralProfileTheme

@Composable
fun TestScreen(
    testUiState: TestUiState,
    handleEvent: (TestUiEvent) -> Unit,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            TestTopAppBar(
                progress = {
                    testUiState.timeProgress
                },
                title = stringResource(R.string.select_one_of_the_words),
                modifier = Modifier.fillMaxWidth(),
                onBackClick = {
                    onBackClick.invoke()
                }
            )
        },
        modifier = modifier
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(it),
            contentPadding = PaddingValues(
                horizontal = 16.dp,
                vertical = 24.dp
            ),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            items(testUiState.words) { word ->
                WordUi(
                    word = word,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            handleEvent.invoke(TestUiEvent.SelectWord(word))
                        }
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun TestScreenPreview() {
    BehavioralProfileTheme {
        TestScreen(
            testUiState = TestUiState(
                words = listOf(
                    TestUiState.WordUi(
                        R.string.page_1_a
                    ),
                    TestUiState.WordUi(
                        R.string.page_1_a
                    ),
                    TestUiState.WordUi(
                        R.string.page_1_a
                    ),
                    TestUiState.WordUi(
                        R.string.page_1_a
                    ),
                ).toMutableStateList(),
                timeProgress = 0.5f
            ),
            handleEvent = {}
        )
    }
}