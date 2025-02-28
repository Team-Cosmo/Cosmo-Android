package kw.team.home.navigation

import androidx.compose.runtime.Stable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import kw.team.home.HomeRoute

@Serializable
data object Home

fun NavGraphBuilder.homeScreen(
    homeNavigation: () -> Unit,
) {
    composable<Home> {
        HomeRoute(
            onStudyButtonClick = { homeNavigation() },
        )
    }
}

@Stable
interface HomeNavigation {
    fun navigateToSolvingForToday()
}
