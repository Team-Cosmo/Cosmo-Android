package kw.team.solving.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kw.team.designsystem.component.CosmoDashboardBox
import kw.team.designsystem.theme.CosmoTheme.colors
import kw.team.designsystem.theme.CosmoTheme.typography
import kw.team.solving.model.QuestionModel

@Composable
internal fun QuestionBox(
    question: QuestionModel,
    modifier: Modifier = Modifier,
) {
    CosmoDashboardBox(
        modifier = modifier,
        content = {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = question.getAssessmentInfo(LocalContext.current),
                    style = typography.label10M,
                    color = colors.onSurface200,
                )
                Spacer(Modifier.height(12.dp))
                Text(
                    text = "Q. ${question.question}",
                    style = typography.title18R,
                    color = colors.onBackground,
                )
            }
        }
    )
}