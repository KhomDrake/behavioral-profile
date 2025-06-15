package br.com.cosmind.app.behavioralprofile.ui.features.result

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import behavioral_profile.composeapp.generated.resources.Res
import behavioral_profile.composeapp.generated.resources.*
import br.com.cosmind.app.behavioralprofile.domain.model.WordType
import br.com.cosmind.app.behavioralprofile.ui.theme.BehavioralProfileTheme
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun WordTypeUi(
    wordTypeUiState: ResultUiState.Success.WordTypeUiState,
    modifier: Modifier = Modifier
) {
    val imageResource = when(wordTypeUiState.wordType) {
        WordType.A -> Res.drawable.eagle
        WordType.B -> Res.drawable.wolf
        WordType.C -> Res.drawable.dolphin
        WordType.D -> Res.drawable.shark
    }

    val title = when(wordTypeUiState.wordType) {
        WordType.A -> Res.string.animal_eagle_name
        WordType.B -> Res.string.animal_wolf_name
        WordType.C -> Res.string.animal_dolphin_name
        WordType.D -> Res.string.animal_shark_name
    }

    val traits = when(wordTypeUiState.wordType) {
        WordType.A -> Res.string.animal_eagle_traits
        WordType.B -> Res.string.animal_wolf_traits
        WordType.C -> Res.string.animal_dolphin_traits
        WordType.D -> Res.string.animal_shark_traits
    }

    val description = when(wordTypeUiState.wordType) {
        WordType.A -> Res.string.animal_eagle_description
        WordType.B -> Res.string.animal_wolf_description
        WordType.C -> Res.string.animal_dolphin_description
        WordType.D -> Res.string.animal_shark_description
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(24.dp)
            )
            .padding(16.dp)
            .then(modifier)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(
                    imageResource
                ),
                contentDescription = null,
                modifier = Modifier
                    .size(64.dp),
            )

            Text(
                text = stringResource(title),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
            )
        }

        Text(
            text = stringResource(traits),
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )

        Text(
            text = stringResource(description),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(Res.string.quantity_selected, wordTypeUiState.selected),
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier
                    .weight(3f)
            )
            Text(
                text = stringResource(Res.string.percentage_selected, wordTypeUiState.percentage),
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier
                    .weight(1f)
            )
        }
    }
}

@Preview
@Composable
private fun WordUiTypePreview() {
    BehavioralProfileTheme {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp)
        ) {
            WordTypeUi(
                wordTypeUiState = ResultUiState.Success.WordTypeUiState(
                    5,
                    20,
                    WordType.A
                ),
                modifier = Modifier
                    .fillMaxWidth()
            )
        }

    }

}