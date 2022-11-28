package dicoding.compose.jetpackprime.presentation.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import dicoding.compose.jetpackprime.R

val NotoSand = FontFamily(
    Font(R.font.notosansextralight,FontWeight.ExtraLight),
    Font(R.font.notosanslight,FontWeight.Light),
    Font(R.font.notosanregular,FontWeight.Normal),
    Font(R.font.notosansmedium,FontWeight.Medium),
    Font(R.font.notosanssemibold,FontWeight.SemiBold),
    Font(R.font.notosansbold,FontWeight.Bold),
    Font(R.font.notosansextrabold,FontWeight.ExtraBold)
)
// Set of Material typography styles to start with
val Typography = Typography(
    h5 = TextStyle(
        fontFamily = NotoSand,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 20.sp,
        color = textColorOne
    ),
    subtitle1 = TextStyle(
        fontFamily = NotoSand,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        color = textColorOne
    ),
    body1 = TextStyle(
        fontFamily = NotoSand,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = textColorOne
    ),
    body2 = TextStyle(
        fontFamily = NotoSand,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = textColorTwo
    ),
    caption = TextStyle(
        fontFamily = NotoSand,
        fontWeight = FontWeight.Light,
        color = textColorTwo,
        fontSize = 12.sp
    ),
    button = TextStyle(
        fontFamily = NotoSand,
        fontWeight = FontWeight.Bold,
        color = textColorOne,
    )
)

