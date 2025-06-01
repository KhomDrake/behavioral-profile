package br.com.cosmind.app.behavioralprofile.ui.navigation

import br.com.cosmind.app.behavioralprofile.domain.model.ResultModel
import kotlinx.serialization.Serializable

sealed interface Route {

    val route: String

    @Serializable
    data class Result(
        val id: Long,
        val quantityA: Int,
        val quantityB: Int,
        val quantityC: Int,
        val quantityD: Int,
        val date: String,
        val name: String? = null
    ): Route {
        override val route: String
            get() = "Result"
    }

    @Serializable
    data object Suite: Route {
        override val route: String
            get() = "Suite"
    }

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
    data object BehavioralTest: Route {
        override val route: String
            get() = "BehavioralTest"

    }
}

fun ResultModel.toResultRoute(): Route.Result {
    return Route.Result(
        id = id,
        quantityA = quantityA,
        quantityB = quantityB,
        quantityC = quantityC,
        quantityD = quantityD,
        date = date,
        name = name
    )
}

fun Route.Result.toResultModel(): ResultModel {
    return ResultModel(
        id = id,
        quantityA = quantityA,
        quantityB = quantityB,
        quantityC = quantityC,
        quantityD = quantityD,
        date = date,
        name = name
    )
}
