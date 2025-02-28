package kw.team.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kw.team.designsystem.theme.CosmoTheme.colors
import kw.team.designsystem.theme.CosmoTheme.typography
import kw.team.home.component.HomeDashboard
import kw.team.home.component.HomeSubjectsGrid
import kw.team.home.component.HomeTopBar
import kw.team.home.model.SubjectUiModel
import kw.team.subject.model.Subject

@Composable
internal fun HomeScreen(
    onStudyButtonClick: () -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        HomeTopBar()
        HomeDashboard(
            onStudyButtonClick = onStudyButtonClick,
        )
        Spacer(modifier = Modifier.height(height = 48.dp))
        Text(
            text = "과목별 학습하기",
            style = typography.headline20M,
            color = colors.onBackground,
            modifier = Modifier.align(alignment = Alignment.Start),
        )
        Spacer(modifier = Modifier.height(height = 16.dp))
        HomeSubjectsGrid(subjects = Subject.entries.map { SubjectUiModel(it) })
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen(
        onStudyButtonClick = {},
    )
}
