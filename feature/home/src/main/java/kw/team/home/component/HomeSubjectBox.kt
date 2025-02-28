package kw.team.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kw.team.designsystem.theme.CosmoTheme
import kw.team.designsystem.theme.CosmoTheme.colors

@Composable
internal fun HomeSubjectBox(
    content: @Composable BoxScope.() -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .background(
                color = colors.onSurface20,
                shape = RoundedCornerShape(size = 10.dp),
            )
            .border(
                width = 1.dp,
                color = colors.onSurface70,
                shape = RoundedCornerShape(size = 10.dp)
            ),
        contentAlignment = Alignment.Center,
        content = content,
    )
}

@Preview
@Composable
private fun HomeSubjectBoxPreview() {
    CosmoTheme {
        HomeSubjectBox(
            content = { Text(text = "Test") }
        )
    }
}
