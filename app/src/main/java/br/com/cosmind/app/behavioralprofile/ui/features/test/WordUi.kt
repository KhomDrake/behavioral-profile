package br.com.cosmind.app.behavioralprofile.ui.features.test

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import br.com.cosmind.app.behavioralprofile.domain.model.WordType
import br.com.cosmind.app.behavioralprofile.ui.theme.BehavioralProfileTheme

@Composable
fun WordUi(
    word: TestUiState.WordUi,
    modifier: Modifier = Modifier,
    showLetter: Boolean = true
) {
    Row(
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.primaryContainer,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(8.dp)
    ) {
        Text(
            word.name,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .weight(1f)
        )
        if(showLetter) {
            Text(
                word.letter,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier
                    .padding(horizontal = 6.dp)
                    .background(
                        color = MaterialTheme.colorScheme.primary,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(horizontal = 6.dp)
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun WordUiPreview() {
    BehavioralProfileTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
        ) {
            WordUi(
                word = TestUiState.WordUi(
                    "Creation",
                    WordType.A.name
                ),
                modifier = Modifier.fillMaxWidth()
            )

        }
    }
}