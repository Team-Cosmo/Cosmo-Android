package kw.team.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kw.team.designsystem.theme.CosmoTheme
import kw.team.designsystem.theme.CosmoTheme.colors
import kw.team.designsystem.theme.CosmoTheme.typography
import kw.team.home.model.SubjectUiModel
import kw.team.subject.model.Subject.Algorithm
import kw.team.subject.model.Subject.DataStructure
import kw.team.subject.model.Subject.Database
import kw.team.subject.model.Subject.Network
import kw.team.subject.model.Subject.OperatingSystem

@Composable
internal fun HomeSubjectsGrid(
    subjects: List<SubjectUiModel>,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        modifier = modifier.fillMaxWidth(),
        columns = GridCells.Fixed(count = 3),
        verticalArrangement = Arrangement.spacedBy(space = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(space = 10.dp),
    ) {
        items(subjects) { subject ->
            HomeSubjectBox(
                content = {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(space = 8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = subject.icon),
                            contentDescription = "HomeSubjectIcon",
                        )
                        Text(
                            text = subject.name,
                            style = typography.title16R,
                            color = colors.onBackground,
                        )
                    }
                },
                modifier = Modifier.size(size = 100.dp),
            )
        }
    }
}

@Preview
@Composable
private fun HomeSubjectsGridPreview() {
    CosmoTheme {
        HomeSubjectsGrid(
            subjects = listOf(
                SubjectUiModel(OperatingSystem),
                SubjectUiModel(DataStructure),
                SubjectUiModel(Algorithm),
                SubjectUiModel(Network),
                SubjectUiModel(Database),
            )
        )
    }
}
