package dicoding.compose.jetpackprime.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dicoding.compose.jetpackprime.R
import dicoding.compose.jetpackprime.model.Cast
import dicoding.compose.jetpackprime.presentation.JetpackPrimeApp
import dicoding.compose.jetpackprime.presentation.component.ActorCard
import dicoding.compose.jetpackprime.presentation.component.Text
import dicoding.compose.jetpackprime.presentation.component.TextType
import dicoding.compose.jetpackprime.presentation.theme.JetpackPrimeTheme
import dicoding.compose.jetpackprime.util.gradientBackground

@Composable
fun DetailMovieScreen(){
    JetpackPrimeApp {
            Box(modifier = Modifier.fillMaxSize()) {
                Image(
                    painter = painterResource(id = R.drawable.movie_doctor_strange),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth
                )
                ContentDetail(modifier = Modifier
                    .fillMaxWidth()
                    .height(
                        LocalConfiguration.current.screenHeightDp.dp * 4 / 5
                    )
                    .align(Alignment.BottomCenter)
                )
        }
    }
}

@Composable
fun ContentDetail(
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .gradientBackground(
                colors = listOf(
                    MaterialTheme.colors.surface,
                    MaterialTheme.colors.surface,
                    MaterialTheme.colors.surface,
                    Color.Transparent
                ),
                angle = 90f
            )
            .padding(horizontal = 16.dp)
            .padding(top = 200.dp)
    ) {
        Text(
            text = "Doctor Strange : Multiverse of Madness",
            type = TextType.TITLE,
            textAlign = TextAlign.Start,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = "2022",
            type = TextType.CAPTION,
        )
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex...",
            type = TextType.BODY2,
        )

        ListActor(
            casts = listOf(
                Cast(1,"https://www.themoviedb.org/t/p/w138_and_h175_face/fBEucxECxGLKVHBznO0qHtCGiMO.jpg","Benedict","Doctor Strange"),
                Cast(2,"https://www.themoviedb.org/t/p/w138_and_h175_face/fBEucxECxGLKVHBznO0qHtCGiMO.jpg","Benedict","Doctor Strange"),
                Cast(3,"https://www.themoviedb.org/t/p/w138_and_h175_face/fBEucxECxGLKVHBznO0qHtCGiMO.jpg","Benedict","Doctor Strange"),
                Cast(4,"https://www.themoviedb.org/t/p/w138_and_h175_face/fBEucxECxGLKVHBznO0qHtCGiMO.jpg","Benedict","Doctor Strange"),
                Cast(5,"https://www.themoviedb.org/t/p/w138_and_h175_face/fBEucxECxGLKVHBznO0qHtCGiMO.jpg","Benedict","Doctor Strange")
            )
        )
    }
}

@Preview
@Composable
private fun ContentDetailPreview() {
    JetpackPrimeTheme {
        ContentDetail(modifier = Modifier
            .fillMaxWidth()
            .height(
                LocalConfiguration.current.screenHeightDp.dp * 3 / 4
            )
        )
    }
}

@Preview
@Composable
private fun DetailMovieScreenPreview(){
    JetpackPrimeTheme {
        DetailMovieScreen()
    }
}

@Composable
fun ListActor(
    modifier: Modifier = Modifier,
    casts:List<Cast>
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.height(150.dp)
    ){
        items(casts, key = {it.id}){element->
            ActorCard(
                cast = element
            )
        }
    }
}
@Preview
@Composable
private fun ListActorPreview() {
    ListActor(
        casts = listOf(
            Cast(1,"https://www.themoviedb.org/t/p/w138_and_h175_face/fBEucxECxGLKVHBznO0qHtCGiMO.jpg","Benedict","Doctor Strange"),
            Cast(2,"https://www.themoviedb.org/t/p/w138_and_h175_face/fBEucxECxGLKVHBznO0qHtCGiMO.jpg","Benedict","Doctor Strange"),
            Cast(3,"https://www.themoviedb.org/t/p/w138_and_h175_face/fBEucxECxGLKVHBznO0qHtCGiMO.jpg","Benedict","Doctor Strange"),
            Cast(4,"https://www.themoviedb.org/t/p/w138_and_h175_face/fBEucxECxGLKVHBznO0qHtCGiMO.jpg","Benedict","Doctor Strange"),
            Cast(5,"https://www.themoviedb.org/t/p/w138_and_h175_face/fBEucxECxGLKVHBznO0qHtCGiMO.jpg","Benedict","Doctor Strange"),
            Cast(6,"https://www.themoviedb.org/t/p/w138_and_h175_face/fBEucxECxGLKVHBznO0qHtCGiMO.jpg","Benedict","Doctor Strange"),
        )
    )
}