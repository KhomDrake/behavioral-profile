package br.com.cosmind.app.behavioralprofile.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import br.com.cosmind.app.behavioralprofile.ui.navigation.Route
import kotlinx.serialization.Serializable

@Serializable
enum class AppDestinations(
    val label: String,
    val icon: ImageVector,
    val route: String
) {
    HOME(
        "Home",
        Icons.Default.Home,
        Route.Home.route
    ),
    FAVORITES(
        "History",
        Icons.Default.AccountBox,
        Route.History.route
    ),
}

@Composable
expect fun NavigationSuite(
    currentDestination: String,
    content: @Composable () -> Unit,
    onClick: (AppDestinations) -> Unit,
    modifier: Modifier = Modifier,
    showItems: Boolean = true
)