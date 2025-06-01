package br.com.cosmind.app.behavioralprofile.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.PreviewLightDark
import br.com.cosmind.app.behavioralprofile.ui.navigation.Route
import br.com.cosmind.app.behavioralprofile.ui.theme.BehavioralProfileTheme
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
fun NavigationSuite(
    currentDestination: String,
    content: @Composable () -> Unit,
    onClick: (AppDestinations) -> Unit,
    modifier: Modifier = Modifier,
    showItems: Boolean = true
) {
    val colors = NavigationSuiteDefaults.itemColors(
        navigationRailItemColors = NavigationRailItemDefaults.colors(
            selectedTextColor = MaterialTheme.colorScheme.onPrimary,
            selectedIconColor = MaterialTheme.colorScheme.onPrimary,
            unselectedIconColor = MaterialTheme.colorScheme.onPrimary,
            unselectedTextColor = MaterialTheme.colorScheme.onPrimary,
            indicatorColor = MaterialTheme.colorScheme.primary
        ),
        navigationBarItemColors = NavigationBarItemDefaults.colors(
            selectedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
            selectedIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
            unselectedIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
            unselectedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
            indicatorColor = MaterialTheme.colorScheme.onPrimary
        ),
        navigationDrawerItemColors = NavigationDrawerItemDefaults.colors(
            selectedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
            selectedIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
            unselectedIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
            unselectedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
            selectedBadgeColor = MaterialTheme.colorScheme.primary
        )
    )

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            if(showItems) {
                AppDestinations.entries.forEach { destination ->
                    item(
                        icon = {
                            Icon(
                                destination.icon,
                                contentDescription = destination.label
                            )
                        },
                        label = {
                            Text(
                                destination.label
                            )
                        },
                        selected = currentDestination == destination.route,
                        onClick = {
                            onClick.invoke(destination)
                        },
                        colors = colors
                    )
                }
            }
        },
        modifier = modifier,
        navigationSuiteColors = NavigationSuiteDefaults.colors(
            navigationBarContainerColor = MaterialTheme.colorScheme.primaryContainer,
            navigationRailContainerColor = MaterialTheme.colorScheme.primaryContainer,
            navigationDrawerContainerColor = MaterialTheme.colorScheme.primaryContainer,
            navigationRailContentColor = MaterialTheme.colorScheme.onPrimaryContainer
        ),
        containerColor = MaterialTheme.colorScheme.background
    ) {
        content.invoke()
    }
}


@PreviewLightDark
@Composable
private fun NavigationSuitePreview() {
    BehavioralProfileTheme {
        NavigationSuite(
            AppDestinations.HOME.route,
            content = {

            },
            onClick = {

            }
        )
    }

}