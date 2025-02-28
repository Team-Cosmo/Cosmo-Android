package kw.team.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kw.team.cosmo.feature.home.R.drawable.ic_logo
import kw.team.cosmo.feature.home.R.drawable.ic_notification
import kw.team.cosmo.feature.home.R.drawable.ic_profile
import kw.team.designsystem.theme.CosmoTheme

@Composable
internal fun HomeTopBar(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = ic_logo),
            contentDescription = "HomeTopBarLogo",
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(space = 8.dp),
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = ic_profile),
                contentDescription = "HomeTopBarProfile",
            )
            Icon(
                imageVector = ImageVector.vectorResource(id = ic_notification),
                contentDescription = "HomeTopBarNotification",
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeTopBarPreview() {
    CosmoTheme {
        HomeTopBar()
    }
}
