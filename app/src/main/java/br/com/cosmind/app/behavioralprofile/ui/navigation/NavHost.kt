package br.com.cosmind.app.behavioralprofile.ui.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.cosmind.app.behavioralprofile.ui.features.home.SuiteScreen

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
            Text("2312321321")
        }
    }
}
