package dicoding.compose.jetpackprime.presentation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dicoding.compose.jetpackprime.presentation.theme.JetpackPrimeTheme

@Composable
fun JetpackPrimeApp(
    content:@Composable (PaddingValues) -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = MaterialTheme.colors.surface
    ){
        content(it)
    }
}

@Preview()
@Composable
private fun JetpackPrimeAppPreview() {
    JetpackPrimeTheme {
        JetpackPrimeApp{

        }
    }
}
