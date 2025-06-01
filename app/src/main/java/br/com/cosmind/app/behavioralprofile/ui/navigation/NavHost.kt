package br.com.cosmind.app.behavioralprofile.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navOptions
import androidx.navigation.toRoute
import br.com.cosmind.app.behavioralprofile.ui.features.home.SuiteScreen
import br.com.cosmind.app.behavioralprofile.ui.features.result.ResultScreen
import br.com.cosmind.app.behavioralprofile.ui.features.result.ResultViewModel
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

            LaunchedEffect(key1 = state.resultModel) {
                state.resultModel?.let { resultModel ->
                    navController.navigate(
                        resultModel.toResultRoute(),
                        navOptions = navOptions {
                            popUpTo(Route.Suite)
                        }
                    )
                }
            }
            TestScreen(
                testUiState = state,
                handleEvent = viewModel::handleEvent,
                modifier = Modifier
                    .fillMaxSize()
            )
        }
        composable<Route.Result> { backStackEntry ->
            val result = backStackEntry.toRoute<Route.Result>()

            val viewModel = koinViewModel<ResultViewModel>()

            val state by viewModel.state.collectAsStateWithLifecycle()

            LaunchedEffect(key1 = Unit) {
                viewModel.setResult(result.toResultModel())
            }

            ResultScreen(
                state = state,
                modifier = Modifier
                    .fillMaxSize(),
                onBackClick = {
                    navController.navigateUp()
                }
            )
        }
    }
}
