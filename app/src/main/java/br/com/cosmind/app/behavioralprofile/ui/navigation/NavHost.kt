package br.com.cosmind.app.behavioralprofile.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.cosmind.app.behavioralprofile.ui.AppDestinations
import br.com.cosmind.app.behavioralprofile.ui.features.home.HomeScreen

@Composable
fun BehavioralProfileNavHost(
    navController: NavHostController,
    innerPadding: PaddingValues,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = AppDestinations.HOME.route,
        modifier = Modifier.padding(innerPadding)
    ) {
        composable(
            route = Route.Home.route,
        ) {
            HomeScreen()
        }
        composable(
            route = Route.History.route,
        ) {
            Text("asdas2")
        }
    }
}
