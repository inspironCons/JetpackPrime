package dicoding.compose.jetpackprime.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = W100,
    primaryVariant = Purple700,
    secondary = Teal200,
    surface = surface,
    background = surface
)

private val LightColorPalette = lightColors(
    primary = W100,
    primaryVariant = Purple700,
    secondary = Teal200,
    surface = surface,
    background = surface
)

@Composable
fun JetpackPrimeTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val systemUiController = rememberSystemUiController()

    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val view = LocalView.current
    if(!view.isInEditMode){
        SideEffect {
            systemUiController.setSystemBarsColor(
                color = surface,
                darkIcons = false
            )
        }
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}