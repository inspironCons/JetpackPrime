package dicoding.compose.jetpackprime.ui.theme

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
    body1 = TextStyle(
        fontFamily = NotoSand,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
)