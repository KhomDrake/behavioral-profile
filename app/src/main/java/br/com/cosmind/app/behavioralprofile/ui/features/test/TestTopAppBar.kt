package br.com.cosmind.app.behavioralprofile.ui.features.test

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.cosmind.app.behavioralprofile.ui.theme.BehavioralProfileTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestTopAppBar(
    title: String,
    progress: () -> Float,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {}
) {
    Column(
        modifier
    ) {
        TopAppBar(
            title = {
                Text(
                    title,
                )
            },
            navigationIcon = {
                IconButton(
                    onClick = onBackClick
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Default.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        )
        LinearProgressIndicator(
            progress = progress,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Preview
@Composable
private fun TestTopAppBarPreview() {
    BehavioralProfileTheme(darkTheme = true) {
        TestTopAppBar(
            title = "Select one of the words",
            progress = {
                0.5f
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}