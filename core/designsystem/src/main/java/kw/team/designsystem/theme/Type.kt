package kw.team.designsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.unit.sp
import kw.team.cosmo.core.designsystem.R.font.pretendard_medium
import kw.team.cosmo.core.designsystem.R.font.pretendard_regular
import kw.team.cosmo.core.designsystem.R.font.pretendard_semibold

private val PretendardRegular = FontFamily(Font(resId = pretendard_regular, weight = Normal))
private val PretendardMedium = FontFamily(Font(resId = pretendard_medium, weight = Medium))
private val PretendardSemibold = FontFamily(Font(resId = pretendard_semibold, weight = SemiBold))

@Stable
class CosmoTypography internal constructor(
    display24R: TextStyle,
    headline20SB: TextStyle,
    headline20M: TextStyle,
    title18R: TextStyle,
    title16R: TextStyle,
    body14R: TextStyle,
    body12R: TextStyle,
    label10M: TextStyle,
) {
    var display24R: TextStyle by mutableStateOf(display24R)
        private set
    var headline20SB: TextStyle by mutableStateOf(headline20SB)
        private set
    var headline20M: TextStyle by mutableStateOf(headline20M)
        private set
    var title18R: TextStyle by mutableStateOf(title18R)
        private set
    var title16R: TextStyle by mutableStateOf(title16R)
        private set
    var body14R: TextStyle by mutableStateOf(body14R)
        private set
    var body12R: TextStyle by mutableStateOf(body12R)
        private set
    var label10M: TextStyle by mutableStateOf(label10M)
        private set

    fun copy(): CosmoTypography = CosmoTypography(
        display24R,
        headline20SB,
        headline20M,
        title18R,
        title16R,
        body14R,
        body12R,
        label10M,
    )

    fun update(other: CosmoTypography) {
        display24R = other.display24R
        headline20SB = other.headline20SB
        headline20M = other.headline20M
        title18R = other.title18R
        title16R = other.title16R
        body14R = other.body14R
        body12R = other.body12R
        label10M = other.label10M
    }
}

@Composable
fun CosmoTypography(): CosmoTypography = CosmoTypography(
    display24R = TextStyle(
        fontFamily = PretendardRegular,
        fontSize = 24.sp,
    ),
    headline20SB = TextStyle(
        fontFamily = PretendardSemibold,
        fontSize = 20.sp,
    ),
    headline20M = TextStyle(
        fontFamily = PretendardMedium,
        fontSize = 20.sp,
    ),
    title18R = TextStyle(
        fontFamily = PretendardRegular,
        fontSize = 18.sp,
    ),
    title16R = TextStyle(
        fontFamily = PretendardRegular,
        fontSize = 16.sp,
    ),
    body14R = TextStyle(
        fontFamily = PretendardRegular,
        fontSize = 14.sp,
    ),
    body12R = TextStyle(
        fontFamily = PretendardRegular,
        fontSize = 12.sp,
    ),
    label10M = TextStyle(
        fontFamily = PretendardMedium,
        fontSize = 10.sp,
    ),
)
