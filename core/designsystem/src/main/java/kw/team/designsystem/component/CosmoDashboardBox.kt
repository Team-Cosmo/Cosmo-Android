package kw.team.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kw.team.designsystem.theme.CosmoTheme.colors

@Composable
fun CosmoDashboardBox(
    content: @Composable BoxScope.() -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .wrapContentSize()
            .background(
                color = colors.onSurface50,
                shape = RoundedCornerShape(size = 16.dp),
            )
            .padding(all = 20.dp),
        content = content,
    )
}

@Preview(showBackground = true)
@Composable
private fun CosmoDashboardBoxPreview() {
    Column {
        CosmoDashboardBox(
            content = {
                Text(
                    text = "CosmoDashboardBox",
                    modifier = Modifier.background(color = Color.Blue)
                )
            }
        )
    }
}
