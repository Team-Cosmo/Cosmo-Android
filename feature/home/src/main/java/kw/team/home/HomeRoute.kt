package kw.team.home

import androidx.compose.runtime.Composable

@Composable
fun HomeRoute(
    onStudyButtonClick: () -> Unit,
) {
    HomeScreen(
        onStudyButtonClick = onStudyButtonClick,
    )
}
