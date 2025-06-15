package br.com.cosmind.app.behavioralprofile.ui

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
import br.com.cosmind.app.behavioralprofile.ui.theme.BehavioralProfileTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
actual fun NavigationSuite(
    currentDestination: String,
    content: @Composable (() -> Unit),
    onClick: (AppDestinations) -> Unit,
    modifier: Modifier,
    showItems: Boolean
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

@Preview
@Composable
private fun NavigationSuitePreview() {
    BehavioralProfileTheme(darkTheme = true) {
        NavigationSuite(
            AppDestinations.HOME.route,
            content = {

            },
            onClick = {

            }
        )
    }

}