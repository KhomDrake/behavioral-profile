package br.com.cosmind.app.behavioralprofile.ui.features.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.com.cosmind.app.behavioralprofile.ui.NavigationSuite
import br.com.cosmind.app.behavioralprofile.ui.navigation.Route

@Composable
fun SuiteScreen(
    nestedNavController: NavHostController
) {
    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationSuite(
        currentDestination?.route ?: "",
        onClick = { destination ->
            if (currentDestination?.route != destination.route) {
                navController.navigate(destination.route) {
                    popUpTo(navController.graph.startDestinationId) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        },
        content = {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                NavHost(
                    navController = navController,
                    startDestination = Route.Home.route,
                    modifier = Modifier
                        .padding(innerPadding)
                ) {
                    composable(
                        route = Route.Home.route,
                    ) {
                        HomeScreen(
                            startTest = {
                                nestedNavController.navigate(Route.BehavioralTest)
                            }
                        )
                    }
                    composable(
                        route = Route.History.route,
                    ) {
                        Text("asdas2")
                    }
                }
            }
        },
        showItems = currentDestination?.route == Route.Home.route || currentDestination?.route == Route.History.route
    )
}
