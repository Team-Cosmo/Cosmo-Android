package kw.team.solving.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable
import kw.team.solving.SolvingScreen
import kw.team.subject.model.Subject

@Serializable
data class Solving(val subject: Subject? = null)

fun NavGraphBuilder.solvingScreen(
    onAiChatClick: (question: String) -> Unit,
) {
    composable<Solving> { backStackEntry ->
        val subject: Solving = backStackEntry.toRoute<Solving>()
        SolvingScreen(
            subject = subject.subject,
            onAiChatClick = onAiChatClick,
        )
    }
}

fun NavController.navigateToSolving() {
    navigate(Solving())
}
