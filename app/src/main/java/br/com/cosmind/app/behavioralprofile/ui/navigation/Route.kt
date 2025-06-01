package br.com.cosmind.app.behavioralprofile.ui.navigation

import kotlinx.serialization.Serializable

sealed interface Route {

    val route: String

    @Serializable
    data object Home: Route {
        override val route: String
            get() = "Home"
    }

    @Serializable
    data object History: Route {
        override val route: String
            get() = "History"
    }

    @Serializable
    data object BehavioralTest
}

