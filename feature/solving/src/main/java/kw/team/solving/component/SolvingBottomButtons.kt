package kw.team.solving.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import kw.team.cosmo.feature.solving.R
import kw.team.designsystem.component.CosmoAiChatButton
import kw.team.designsystem.theme.CosmoTheme.colors
import kw.team.designsystem.theme.CosmoTheme.typography

@Composable
internal fun SolvingBottomButtons(
    onReturnClick: () -> Unit,
    onAiChatClick: () -> Unit,
    isReturnClickable: Boolean,
    modifier: Modifier = Modifier,
) {
    Row(modifier = modifier) {
        ReturnButton(
            onClick = onReturnClick,
            isClickable = isReturnClickable,
            modifier = Modifier.weight(1f),
        )
        Spacer(Modifier.width(12.dp))
        CosmoAiChatButton(
            onClick = onAiChatClick,
        )
    }
}

@Composable
private fun ReturnButton(
    onClick: () -> Unit,
    isClickable: Boolean,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = if (isClickable) colors.primary else colors.onSurface200,
                shape = RoundedCornerShape(30.dp)
            )
            .clickable(enabled = isClickable) { onClick() }
            .padding(vertical = 18.dp),
    ) {
        Text(
            text = stringResource(R.string.return_answer),
            style = typography.title18R,
            color = colors.background,
            modifier = Modifier.align(Alignment.Center),
        )
    }
}