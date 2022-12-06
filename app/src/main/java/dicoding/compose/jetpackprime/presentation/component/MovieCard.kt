package dicoding.compose.jetpackprime.presentation.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import dicoding.compose.jetpackprime.model.Movies
import dicoding.compose.jetpackprime.presentation.theme.JetpackPrimeTheme
import dicoding.compose.jetpackprime.presentation.theme.PrimeShape
import dicoding.compose.jetpackprime.util.General.generateColor
import dicoding.compose.jetpackprime.util.gradientBackground

@Composable
fun TrendingMovieCard(
    data:Movies,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier
        .fillMaxWidth()
        .height(150.dp)) {
        CardContent(
            modifier = Modifier.align(Alignment.BottomCenter),
            title=data.title,
            year=data.year
        )
        AsyncImage(
            model = data.image,
            contentDescription = null,
            modifier = Modifier
                .height(140.dp)
                .width(100.dp)
                .padding(top = 8.dp, start = 4.dp)
                .clip(PrimeShape)
                .align(Alignment.BottomStart),
            contentScale = ContentScale.Fit
        )
        Text(text = data.number.toString(),
            style = MaterialTheme.typography.h5.copy(fontSize = 60.sp),
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(end = 24.dp),
            textAlign = TextAlign.Start
        )
    }

}

@Composable
fun CardContent(
    modifier: Modifier,
    title:String,
    year:String
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            .shadow(
                elevation = 4.dp,
                shape = PrimeShape,
                ambientColor = DefaultShadowColor
            )
            .padding(2.dp)
            .height(80.dp)
            .clip(PrimeShape)
            .gradientBackground(
                colors = generateColor(),
                angle = 30f
            )
            .padding(start = 90.dp, end = 16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title, style = MaterialTheme.typography.h5.copy(
            fontSize = 16.sp),
            modifier = Modifier.fillMaxWidth(),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
        Text(text = year, type = TextType.BODY1)
    }
}

@Preview
@Composable
fun TrendingMovieCardPreview() {
    JetpackPrimeTheme {
        TrendingMovieCard(
            Movies(
                image  = "https://image.tmdb.org/t/p/w500/pFlaoHTZeyNkG83vxsAJiGzfSsa.jpg",
                number = 1,
                title = "Black Adam",
                year = "2022",
                id = 1
            )
        )
    }
}

@Composable
fun MovieCard(
    data:Movies,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier.padding(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = data.image,
            contentDescription = null,
            modifier = Modifier
                .size(120.dp)
                .clip(PrimeShape),
            contentScale = ContentScale.Crop
        )
        Text(text = data.title, textAlign = TextAlign.Center, style = MaterialTheme.typography.h5.copy(
            fontSize = 14.sp,
        ))
        Text(text = data.year, style = MaterialTheme.typography.caption.copy(
            fontSize = 12.sp
        ))
    }
}

@Preview
@Composable
fun MovieCardPreview(){
    JetpackPrimeTheme {
        MovieCard(
            Movies(
                image  = "https://image.tmdb.org/t/p/w500/pFlaoHTZeyNkG83vxsAJiGzfSsa.jpg",
                number = 1,
                title = "Black Adam",
                year = "2022",
                id = 1
            )
        )
    }
}