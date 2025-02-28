package kw.team.designsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

// Gray Scale
private val Black = Color(0xFF111118)
private val Gray300 = Color(0xFF4A4A4A)
private val Gray200 = Color(0xFF939393)
private val Gray100 = Color(0xFF9E9FA8)
private val Gray70 = Color(0xFFE9E9E9)
private val Gray50 = Color(0xFFF0F0F2)
private val Gray20 = Color(0xFFFAFAFA)
private val White = Color(0xFFFFFFFF)

// Blue Scale
private val Blue800 = Color(0xFF2D2E43)
private val Blue700 = Color(0xFF616879)

// Purple Scale
private val Purple100 = Color(0xFFA7ABFF)

@Stable
class CosmoColors(
    primary: Color,
    onPrimary: Color,
    secondary: Color,
    background: Color,
    onBackground: Color,
    onSurface300: Color,
    onSurface200: Color,
    onSurface100: Color,
    onSurface70: Color,
    onSurface50: Color,
    onSurface20: Color,
) {
    var primary by mutableStateOf(primary)
        private set
    var onPrimary by mutableStateOf(onPrimary)
        private set
    var secondary by mutableStateOf(secondary)
        private set
    var background by mutableStateOf(background)
        private set
    var onBackground by mutableStateOf(onBackground)
        private set
    var onSurface300 by mutableStateOf(onSurface300)
        private set
    var onSurface200 by mutableStateOf(onSurface200)
        private set
    var onSurface100 by mutableStateOf(onSurface100)
        private set
    var onSurface70 by mutableStateOf(onSurface70)
        private set
    var onSurface50 by mutableStateOf(onSurface50)
        private set
    var onSurface20 by mutableStateOf(onSurface20)
        private set

    fun copy(): CosmoColors = CosmoColors(
        primary,
        onPrimary,
        secondary,
        background,
        onBackground,
        onSurface300,
        onSurface200,
        onSurface100,
        onSurface70,
        onSurface50,
        onSurface20,
    )

    fun update(other: CosmoColors) {
        primary = other.primary
        onPrimary = other.onPrimary
        secondary = other.secondary
        background = other.background
        onBackground = other.onBackground
        onSurface300 = other.onSurface300
        onSurface200 = other.onSurface200
        onSurface100 = other.onSurface100
        onSurface70 = other.onSurface70
        onSurface50 = other.onSurface50
        onSurface20 = other.onSurface20
    }
}

@Composable
internal fun CosmoLightColors(
    primary: Color = Blue800,
    onPrimary: Color = Blue700,
    secondary: Color = Purple100,
    background: Color = White,
    onBackground: Color = Black,
    onSurface300: Color = Gray300,
    onSurface200: Color = Gray200,
    onSurface100: Color = Gray100,
    onSurface70: Color = Gray70,
    onSurface50: Color = Gray50,
    onSurface20: Color = Gray20,
) = CosmoColors(
    primary,
    onPrimary,
    secondary,
    background,
    onBackground,
    onSurface300,
    onSurface200,
    onSurface100,
    onSurface70,
    onSurface50,
    onSurface20,
)
