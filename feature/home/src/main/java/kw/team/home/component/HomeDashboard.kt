package kw.team.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kw.team.cosmo.feature.home.R.drawable.ic_study
import kw.team.designsystem.component.CosmoButton
import kw.team.designsystem.component.CosmoDashboardBox
import kw.team.designsystem.theme.CosmoTheme
import kw.team.designsystem.theme.CosmoTheme.colors
import kw.team.designsystem.theme.CosmoTheme.typography

@Composable
internal fun HomeDashboard(
    onStudyButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    CosmoDashboardBox(
        modifier = modifier,
        content = {
            Column {
                Text(
                    text = "아직 학습을 시작하지 않았어요.",
                    style = typography.title16R,
                    color = colors.onBackground,
                )
                Spacer(modifier = Modifier.height(height = 28.dp))
                CosmoButton(
                    onClick = onStudyButtonClick,
                    content = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(space = 8.dp),
                            modifier = Modifier.padding(vertical = 12.dp),
                        ) {
                            Icon(
                                imageVector = ImageVector.vectorResource(id = ic_study),
                                contentDescription = "CosmoButtonStudyIcon",
                            )
                            Text(
                                text = "오늘 학습하기",
                                style = typography.title16R,
                                color = colors.background,
                            )
                        }
                    },
                )
            }
        },
    )
}

@Preview(showBackground = true)
@Composable
private fun HomeDashboardPreview() {
    CosmoTheme {
        HomeDashboard(
            onStudyButtonClick = {},
        )
    }
}
