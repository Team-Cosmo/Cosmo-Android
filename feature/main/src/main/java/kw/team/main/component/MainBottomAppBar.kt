package kw.team.main.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kw.team.designsystem.theme.CosmoTheme
import kw.team.designsystem.theme.CosmoTheme.colors
import kw.team.designsystem.theme.CosmoTheme.typography
import kw.team.main.model.MainBottomAppBarTab

@Composable
internal fun MainBottomAppBar(
    currentTab: MainBottomAppBarTab,
    tabs: List<MainBottomAppBarTab>,
    onTabClick: (selectedTab: MainBottomAppBarTab) -> Unit,
    modifier: Modifier = Modifier,
) {
    BottomAppBar(
        modifier = modifier
            .border(
                width = 1.dp,
                color = colors.onSurface20,
            ),
        containerColor = colors.background,
        actions = {
            tabs.forEach { tab ->
                MainBottomAppBarItem(
                    tab = tab,
                    isSelected = currentTab == tab,
                    onItemClick = { onTabClick(tab) },
                )
            }
        },
    )
}

@Composable
private fun RowScope.MainBottomAppBarItem(
    tab: MainBottomAppBarTab,
    isSelected: Boolean,
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    NavigationBarItem(
        modifier = modifier,
        selected = isSelected,
        onClick = onItemClick,
        icon = {
            Icon(
                imageVector = ImageVector.vectorResource(id = tab.iconResId),
                contentDescription = tab.contentDescription,
            )
        },
        label = {
            Text(
                text = tab.title,
                style = typography.label10M,
            )
        },
        colors = NavigationBarItemDefaults.colors(
            indicatorColor = colors.background,
            unselectedIconColor = colors.onSurface100,
            unselectedTextColor = colors.onSurface100,
        ),
    )
}

@Preview(showBackground = true)
@Composable
private fun CosmoBottomAppBarPreview() {
    CosmoTheme {
        MainBottomAppBar(
            currentTab = MainBottomAppBarTab.HOME,
            tabs = MainBottomAppBarTab.entries,
            onTabClick = {},
        )
    }
}
