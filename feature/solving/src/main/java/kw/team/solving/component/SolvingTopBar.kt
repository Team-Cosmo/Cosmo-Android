package kw.team.solving.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import kw.team.cosmo.feature.solving.R.drawable.ic_navigate_left
import kw.team.cosmo.feature.solving.R.drawable.ic_save
import kw.team.designsystem.theme.CosmoTheme.colors

@Composable
internal fun SolvingTopBar(
    isSaved: Boolean,
    goBack: () -> Unit,
    save: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = ic_navigate_left),
            contentDescription = "SolvingTopBarBack",
            modifier = Modifier.clickable(onClick = goBack)
        )
        Icon(
            imageVector = ImageVector.vectorResource(id = ic_save),
            contentDescription = "SolvingTopBarSave",
            tint = if (isSaved) colors.primary else colors.onSurface200,
            modifier = Modifier
                .padding(10.dp)
                .clickable(onClick = save),
        )
    }
}