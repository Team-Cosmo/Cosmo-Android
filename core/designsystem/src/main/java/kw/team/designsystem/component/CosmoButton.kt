package kw.team.designsystem.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kw.team.designsystem.theme.CosmoTheme
import kw.team.designsystem.theme.CosmoTheme.colors

@Composable
fun CosmoButton(
    onClick: () -> Unit,
    content: @Composable RowScope.() -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick,
        shape = RoundedCornerShape(size = 30.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = colors.primary,
        ),
        content = content,
    )
}

@Preview(showBackground = true)
@Composable
private fun CosmoButtonPreview() {
    CosmoTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            CosmoButton(
                onClick = {},
                content = {
                    Text("버튼")
                }
            )
        }
    }
}
