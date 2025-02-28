package kw.team.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf

private val LocalCosmoColors = staticCompositionLocalOf<CosmoColors> {
    error("No CosmoColors provided")
}

private val LocalCosmoTypography = staticCompositionLocalOf<CosmoTypography> {
    error("No CosmoTypography provided")
}

object CosmoTheme {
    val colors: CosmoColors
        @Composable
        @ReadOnlyComposable
        get() = LocalCosmoColors.current

    val typography: CosmoTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalCosmoTypography.current
}

@Composable
fun CosmoTheme(
    // Dark mode is not available
    darkTheme: Boolean = false,
    content: @Composable () -> Unit,
) {
    val colors = CosmoLightColors()
    val typography = CosmoTypography()

    provideCosmoTheme(
        colors = colors,
        typography = typography,
    ) {
        MaterialTheme(content = content)
    }
}

@Composable
private fun provideCosmoTheme(
    colors: CosmoColors,
    typography: CosmoTypography,
    content: @Composable () -> Unit,
) {
    val provideColors = remember(colors) { colors.copy().apply { update(colors) } }
    val provideTypography = remember(typography) { typography.copy().apply { update(typography) } }

    CompositionLocalProvider(
        LocalCosmoColors provides provideColors,
        LocalCosmoTypography provides provideTypography,
        content = content,
    )
}
