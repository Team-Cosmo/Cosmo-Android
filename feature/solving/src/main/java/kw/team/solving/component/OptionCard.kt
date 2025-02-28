package kw.team.solving.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kw.team.designsystem.theme.CosmoTheme.colors
import kw.team.designsystem.theme.CosmoTheme.typography
import kw.team.solving.model.SelectableOption

@Composable
internal fun Option(
    option: SelectableOption,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .background(
                color = colors.onSurface20,
                shape = RoundedCornerShape(10),
            )
            .border(
                width = 1.dp,
                color = if (option.isSelected) colors.primary else colors.onSurface70,
                shape = RoundedCornerShape(10),
            )
            .padding(20.dp)
    ) {
        Text(
            text = "${option.value}. ${option.content}",
            style = typography.body14R,
            color = colors.onBackground,
        )
    }
}

@Composable
@Preview
private fun OptionPreview() {
    Option(
        option = SelectableOption(1, "1번 보기입니다.", false),
    )
}