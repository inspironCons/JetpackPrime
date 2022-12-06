package dicoding.compose.jetpackprime.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dicoding.compose.jetpackprime.R
import dicoding.compose.jetpackprime.presentation.theme.JetpackPrimeTheme

@Composable
fun MessageState(
    modifier: Modifier = Modifier,
    image:Int,
    message:String
){
    Column(modifier = modifier.padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = image), contentDescription = null,modifier = Modifier.size(120.dp))
        Text(text = message, type = TextType.BODY1)
    }
}

@Preview
@Composable
fun MessageStatePreview(){
    JetpackPrimeTheme {
        MessageState(image = R.drawable.ic_error_state, message = "Error State")
    }
}