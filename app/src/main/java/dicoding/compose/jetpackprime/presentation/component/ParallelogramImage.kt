package dicoding.compose.jetpackprime.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dicoding.compose.jetpackprime.R
import dicoding.compose.jetpackprime.presentation.theme.JetpackPrimeTheme

@Composable
fun ParallelogramImage(
    modifier: Modifier = Modifier,
    image: Int
){
    Box(
        modifier = modifier
            .height(200.dp)
            .clip(
                GenericShape { size, _ ->
                    val radian = 73 * Math.PI / 165
                    val xOnOpposite = (size.height * kotlin.math.tan(radian)).toFloat()
                    moveTo(0f, size.height)
                    lineTo(x = xOnOpposite, y = 0f)
                    lineTo(x = size.width, y = 0f)
                    lineTo(x = size.width - xOnOpposite, y = size.height)
                    lineTo(x = xOnOpposite, y = size.height)
                }
            )
    ) {
        Image(
            painterResource(id = image) ,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Composable
fun ParallelogramImages(
    modifier: Modifier = Modifier,
    images:List<Int>
){
    Column(modifier = modifier) {
        images.mapIndexed{ i, image ->
            if(i == 0){
                ParallelogramImage( image = image)
            }else{
                val y = (-56 * i).dp
                ParallelogramImage(
                    image = image,
                    modifier = Modifier.offset(0.dp,y)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ParallelogramImagePreview(){
    JetpackPrimeTheme {
        ParallelogramImage( image = R.drawable.movie_kkn_desa_penari)

    }
}

@Preview(showBackground = true)
@Composable
fun ParallelogramImagesPreview(){
    JetpackPrimeTheme {
        ParallelogramImages(
            images = listOf(
                R.drawable.movie_doctor_strange,
                R.drawable.movie_kkn_desa_penari,
                R.drawable.movie_kkn_desa_penari,
            )
        )
    }
}