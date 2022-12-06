package dicoding.compose.jetpackprime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import dicoding.compose.jetpackprime.presentation.JetpackPrimeApp
import dicoding.compose.jetpackprime.presentation.theme.JetpackPrimeTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackPrimeTheme {
                JetpackPrimeApp()
            }
        }
    }
}
