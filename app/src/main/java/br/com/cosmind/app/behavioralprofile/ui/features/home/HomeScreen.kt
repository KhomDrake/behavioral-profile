package br.com.cosmind.app.behavioralprofile.ui.features.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import br.com.cosmind.app.behavioralprofile.R
import br.com.cosmind.app.behavioralprofile.ui.theme.BehavioralProfileTheme

@Composable
fun HomeScreen(
    startTest: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
    ) {
        Text(
            stringResource(R.string.welcome_title),
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.size(24.dp))
        Text(
            stringResource(R.string.welcome_body_1),
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(Modifier.size(8.dp))
        Text(
            stringResource(R.string.welcome_body_2),
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(Modifier.size(8.dp))
        Text(
            stringResource(R.string.welcome_body_3),
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(Modifier.size(8.dp))
        Text(
            stringResource(R.string.welcome_body_4),
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(Modifier.size(24.dp))
        Button(
            onClick = {
                startTest()
            },
            content = {
                Text(
                    stringResource(R.string.start_button_text),
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier,
                    textAlign = TextAlign.Center
                )
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ),
            modifier = Modifier
                .fillMaxWidth()
        )

    }
}

@PreviewLightDark
@Composable
private fun HomeScreenPreview() {
    BehavioralProfileTheme {
        HomeScreen()
    }
}