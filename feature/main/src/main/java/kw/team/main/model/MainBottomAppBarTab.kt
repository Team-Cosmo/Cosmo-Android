package kw.team.main.model

import androidx.annotation.DrawableRes
import kw.team.cosmo.feature.main.R.drawable.ic_folder
import kw.team.cosmo.feature.main.R.drawable.ic_home

internal enum class MainBottomAppBarTab(
    @DrawableRes val iconResId: Int,
    val title: String,
    val contentDescription: String,
) {
    HOME(
        iconResId = ic_home,
        title = "홈",
        contentDescription = "MainBottomAppBarTabHome"
    ),

    STORAGE(
        iconResId = ic_folder,
        title = "보관함",
        contentDescription = "MainBottomAppBarTabStorage"
    )
}
