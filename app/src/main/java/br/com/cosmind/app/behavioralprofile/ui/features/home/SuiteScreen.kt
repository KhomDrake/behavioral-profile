package br.com.cosmind.app.behavioralprofile.ui.features.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.com.cosmind.app.behavioralprofile.ui.NavigationSuite
import br.com.cosmind.app.behavioralprofile.ui.features.history.HistoryEvent
import br.com.cosmind.app.behavioralprofile.ui.features.history.HistoryScreen
import br.com.cosmind.app.behavioralprofile.ui.features.history.HistoryUiState
import br.com.cosmind.app.behavioralprofile.ui.features.history.HistoryViewModel
import br.com.cosmind.app.behavioralprofile.ui.navigation.Route
import br.com.cosmind.app.behavioralprofile.ui.navigation.toResultRoute
import br.com.cosmind.app.behavioralprofile.util.LaunchEffectLifecycleEvent
import org.koin.androidx.compose.koinViewModel

@Composable
fun SuiteScreen(
    navController: NavHostController
) {
    val nestedNavController = rememberNavController()

    val navBackStackEntry by nestedNavController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationSuite(
        currentDestination?.route ?: "",
        onClick = { destination ->
            if (currentDestination?.route != destination.route) {
                nestedNavController.navigate(destination.route) {
                    popUpTo(nestedNavController.graph.startDestinationId) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        },
        content = {
            NavHost(
                navController = nestedNavController,
                startDestination = Route.Home.route,
                modifier = Modifier
            ) {
                composable(
                    route = Route.Home.route,
                ) {
                    HomeScreen(
                        startTest = {
                            navController.navigate(Route.BehavioralTest)
                        }
                    )
                }
                composable(
                    route = Route.History.route,
                ) {
                    val viewModel = koinViewModel<HistoryViewModel>()

                    val state by viewModel.state.collectAsStateWithLifecycle()

                    LaunchedEffect(key1 = state) {
                        (state as? HistoryUiState.Success)?.goToResult?.let {
                            navController.navigate(
                                it.toResultRoute()
                            )
                            viewModel.handleEvent(HistoryEvent.RestNavigation)
                        }
                    }

                    LaunchEffectLifecycleEvent(
                        onClick = {
                            viewModel.loadHistory()
                        },
                        lifecycleEvent = Lifecycle.Event.ON_START,
                    )

                    HistoryScreen(
                        state = state,
                        modifier = Modifier
                            .fillMaxSize(),
                        handleEvent = viewModel::handleEvent
                    )
                }
            }
        },
        showItems = currentDestination?.route == Route.Home.route || currentDestination?.route == Route.History.route
    )
}
