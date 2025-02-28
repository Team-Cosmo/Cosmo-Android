package kw.team.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kw.team.cosmo.feature.main.R.drawable.ic_send
import kw.team.designsystem.theme.CosmoTheme
import kw.team.designsystem.theme.CosmoTheme.colors
import kw.team.designsystem.theme.CosmoTheme.typography

@Composable
internal fun MainAiChatTextFieldBar(
    text: String,
    onTextValueChanged: (String) -> Unit,
    onIconClick: () -> Unit,
    placeHolder: @Composable () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = colors.secondary,
                shape = RoundedCornerShape(size = 30.dp),
            )
            .background(
                color = colors.background,
                shape = RoundedCornerShape(size = 30.dp),
            ),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
        ) {
            TextField(
                textStyle = typography.body14R,
                value = text,
                onValueChange = onTextValueChanged,
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Transparent,
                    unfocusedIndicatorColor = Transparent,
                    focusedContainerColor = Transparent,
                    focusedIndicatorColor = Transparent,
                ),
                placeholder = { placeHolder() },
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .weight(weight = 1f),
            )
            Icon(
                imageVector = ImageVector.vectorResource(id = ic_send),
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 20.dp)
                    .size(size = 20.dp)
                    .clickable { onIconClick() }
            )
        }
    }
}

@Preview
@Composable
private fun MainAiChatTextFieldBarPreview() {
    CosmoTheme {
        MainAiChatTextFieldBar(
            text = "",
            onTextValueChanged = {},
            onIconClick = {},
            placeHolder = {},
        )
    }
}
