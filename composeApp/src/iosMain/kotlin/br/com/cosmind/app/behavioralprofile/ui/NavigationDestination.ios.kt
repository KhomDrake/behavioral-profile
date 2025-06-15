package br.com.cosmind.app.behavioralprofile.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
actual fun NavigationSuite(
    currentDestination: String,
    content: @Composable (() -> Unit),
    onClick: (AppDestinations) -> Unit,
    modifier: Modifier,
    showItems: Boolean
) {
    Scaffold(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.background,
        bottomBar = {
            if(showItems) {
                NavigationBar(
                    modifier = modifier,
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                ) {
                    AppDestinations.entries.forEach { destination ->
                        NavigationBarItem(
                            selected = currentDestination == destination.route,
                            onClick = {
                                onClick.invoke(destination)
                            },
                            icon = {
                                Icon(
                                    destination.icon,
                                    contentDescription = destination.label,

                                    )
                            },
                            label = {
                                Text(
                                    destination.label
                                )
                            },
                            colors = NavigationBarItemDefaults.colors(
                                selectedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                                selectedIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
                                unselectedIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
                                unselectedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                                indicatorColor = MaterialTheme.colorScheme.onPrimary
                            )
                        )
                    }
                }
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            content.invoke()
        }
    }
}