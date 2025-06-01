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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import br.com.cosmind.app.behavioralprofile.ui.theme.BehavioralProfileTheme

@Composable
fun HomeScreen(
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
    ) {
        Text(
            "Welcome to Behavioral Profile",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.size(24.dp))
        Text(
            "Behavioral Profile is an App where you can take a behavioral test and see what animals most combine with your personality.",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(Modifier.size(8.dp))
        Text(
            "The test consists of 25 group of 4 words, each words has of the letters A, B, C, D right beside. You are going to have 7 seconds to choose one word, you select the word by clicking on it.",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(Modifier.size(8.dp))
        Text(
            "After selecting 25 words, you will see the results and explanations about each animals",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(Modifier.size(8.dp))
        Text(
            "You could take this test online, but by doing in this App, you are going to see the order of the words differently and be able to share with friends your result",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(Modifier.size(24.dp))
        Button(
            onClick = {

            },
            content = {
                Text(
                    "Start",
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