package dicoding.compose.jetpackprime.presentation.screen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dicoding.compose.jetpackprime.R
import dicoding.compose.jetpackprime.presentation.theme.JetpackPrimeTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onSplashDone:()->Unit = {}
) {
    var startAnimation by remember {
        mutableStateOf(false)
    }
    val alphaAnim = animateFloatAsState(
        targetValue = if(startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 3000)
    )

    LaunchedEffect(key1 = true){
        startAnimation = true
        delay(4000)
        onSplashDone()
    }

    Box(modifier = Modifier.fillMaxSize().alpha(alphaAnim.value)) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription =null,
            modifier = Modifier
                .align(Alignment.Center)
                .size(200.dp)
        )
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    JetpackPrimeTheme {
        SplashScreen()
    }
}