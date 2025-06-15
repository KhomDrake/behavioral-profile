package br.com.cosmind.app.behavioralprofile

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import br.com.cosmind.app.behavioralprofile.ui.navigation.BehavioralProfileNavHost
import br.com.cosmind.app.behavioralprofile.ui.theme.BehavioralProfileTheme
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App() {
    BehavioralProfileTheme {
        val navController = rememberNavController()

        BehavioralProfileNavHost(
            navController
        )
    }
}