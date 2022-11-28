package dicoding.compose.jetpackprime.presentation.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dicoding.compose.jetpackprime.model.Cast
import dicoding.compose.jetpackprime.presentation.theme.CardShape
import dicoding.compose.jetpackprime.presentation.theme.DavyGrey
import dicoding.compose.jetpackprime.presentation.theme.JetpackPrimeTheme

@Composable
fun ActorCard(
    modifier: Modifier = Modifier,
    cast:Cast
) {
    Box(
        modifier = modifier.height(60.dp)
    ) {

        Card(
            modifier = Modifier
                .widthIn(max = 180.dp)
                .height(50.dp)
                .align(Alignment.CenterStart),
            border = BorderStroke(width = 1.dp, color = DavyGrey),
            shape = CardShape,
            elevation = 4.dp
        ) {
            Column(
                modifier = Modifier.padding(start = 50.dp, end = 16.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = cast.cast,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.h5.copy(
                        fontSize = 10.sp
                    )
                )
                Text(
                    text = cast.cast,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.body1.copy(
                        fontSize = 10.sp
                    )
                )
            }
        }

        RoundedImage(
            modifier = Modifier
                .size(50.dp)
                .align(Alignment.CenterStart),
            image = cast.image
        )

    }
}

@Preview()
@Composable
fun ActorCardPreview() {
    JetpackPrimeTheme() {
        ActorCard(
            cast = Cast(
                id = 1,
                image = "https://www.themoviedb.org/t/p/w138_and_h175_face/fBEucxECxGLKVHBznO0qHtCGiMO.jpg",
                cast = "Benedict",
                name = "Doctor Strange"
            )
        )
    }
}

