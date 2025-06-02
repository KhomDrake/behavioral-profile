package br.com.cosmind.app.behavioralprofile.ui.features.history

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.cosmind.app.behavioralprofile.R
import br.com.cosmind.app.behavioralprofile.domain.model.WordType
import br.com.cosmind.app.behavioralprofile.ui.theme.BehavioralProfileTheme

@Composable
fun HistoryItemUi(
    historyUiItemState: HistoryUiItemState,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults
            .cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = historyUiItemState.date,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.behavioral_profile_result) + ":", // Or a more specific string
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
                Text(
                    text = getAnimalName(wordType = historyUiItemState.highest),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }
    }
}

@Composable
private fun getAnimalName(wordType: WordType): String {
    return when (wordType) {
        WordType.A -> stringResource(id = R.string.animal_eagle_name)
        WordType.B -> stringResource(id = R.string.animal_wolf_name)
        WordType.C -> stringResource(id = R.string.animal_dolphin_name)
        WordType.D -> stringResource(id = R.string.animal_shark_name)
    }
}

@Preview
@Composable
private fun HistoryItemUiPreview() {
    BehavioralProfileTheme {
        HistoryItemUi(
            historyUiItemState = HistoryUiItemState(
                date = "October 26, 2023",
                highest = WordType.A,
                id = 2
            )
        )
    }
}

@Preview
@Composable
private fun HistoryItemUiPreviewDark() {
    BehavioralProfileTheme(darkTheme = true) {
        HistoryItemUi(
            historyUiItemState = HistoryUiItemState(
                date = "November 15, 2023",
                highest = WordType.C,
                id = 3
            )
        )
    }
}