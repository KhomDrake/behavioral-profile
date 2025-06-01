package br.com.cosmind.app.behavioralprofile.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.cosmind.app.behavioralprofile.ui.features.home.SuiteScreen
import br.com.cosmind.app.behavioralprofile.ui.features.test.TestScreen
import br.com.cosmind.app.behavioralprofile.ui.features.test.TestViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun BehavioralProfileNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Route.Suite,
        modifier = modifier
    ) {
        composable<Route.Suite> {
            SuiteScreen(
                navController
            )
        }
        composable<Route.BehavioralTest> {
            val viewModel = koinViewModel<TestViewModel>()

            val state by viewModel.state.collectAsStateWithLifecycle()

            TestScreen(
                testUiState = state,
                handleEvent = viewModel::handleEvent,
                modifier = Modifier
                    .fillMaxSize()
            )
        }
    }
}
