package dicoding.compose.jetpackprime.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dicoding.compose.jetpackprime.R
import dicoding.compose.jetpackprime.presentation.component.NeonButton
import dicoding.compose.jetpackprime.presentation.component.ParallelogramImages
import dicoding.compose.jetpackprime.presentation.component.Text
import dicoding.compose.jetpackprime.presentation.component.TextType
import dicoding.compose.jetpackprime.presentation.theme.JetpackPrimeTheme


@Composable
fun OnBoardingScreen() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        backgroundColor = MaterialTheme.colors.surface,
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            ParallelogramImages(
                images = listOf(
                    R.drawable.movie_one,
                    R.drawable.movie_doctor_strange,
                    R.drawable.movie_kkn_desa_penari,
                ),
                modifier = Modifier.padding(top = 40.dp)
            )
            Column(modifier = Modifier.padding(top = 530.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = stringResource(id = R.string.app_name),
                    type = TextType.TITLE
                )
                Text(
                    text = stringResource(id = R.string.welcome_on_board),
                    type = TextType.BODY1,
                    modifier = Modifier
                        .padding(horizontal = 24.dp, vertical = 30.dp),
                    textAlign = TextAlign.Center
                )
                NeonButton(
                    text = "Enter Now",
                    onClick = {},
                )
            }
        }
    }
}

@Preview(name = "onboarding page")
@Composable
fun OnBoardingScreenPreview() {
    JetpackPrimeTheme {
        OnBoardingScreen()
    }
}