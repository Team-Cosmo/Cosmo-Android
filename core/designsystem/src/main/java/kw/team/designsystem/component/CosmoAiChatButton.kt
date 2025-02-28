package kw.team.designsystem.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kw.team.cosmo.core.designsystem.R.drawable.ic_ai_bot
import kw.team.designsystem.theme.CosmoTheme
import kw.team.designsystem.theme.CosmoTheme.colors

@Composable
fun CosmoAiChatButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    elevation: Dp = 0.dp,
) {
    FloatingActionButton(
        modifier = modifier,
        onClick = onClick,
        shape = CircleShape,
        elevation = FloatingActionButtonDefaults.elevation(
            defaultElevation = elevation,
        ),
        containerColor = colors.secondary,
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = ic_ai_bot),
            contentDescription = "CosmoAiChatButton",
            tint = colors.background,
            modifier = Modifier.padding(all = 16.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CosmoAiChatButtonPreview() {
    CosmoTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            CosmoAiChatButton(
                onClick = {},
            )
        }
    }
}
