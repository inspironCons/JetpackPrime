package dicoding.compose.jetpackprime.presentation.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dicoding.compose.jetpackprime.presentation.theme.JetpackPrimeTheme
import androidx.compose.material.Text as MText

@Composable
fun NeonButton(
    modifier: Modifier = Modifier,
    text:String,
    onClick:()->Unit = {}
){
    Button(
        modifier = modifier.padding(8.dp),
        onClick = onClick,
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp
        ),
        colors = ButtonDefaults.outlinedButtonColors(
            backgroundColor = Color.Transparent
        ),
        border = BorderStroke(1.dp,Color.White),
        shape = RoundedCornerShape(50.dp)
    ) {
        MText(text = text)
    }
}

@Preview()
@Composable
fun NeonButtonPreview(){
    JetpackPrimeTheme {
        NeonButton(text = "enter now")
    }
}