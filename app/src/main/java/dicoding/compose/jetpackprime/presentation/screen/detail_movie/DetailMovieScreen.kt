package dicoding.compose.jetpackprime.presentation.screen.detail_movie

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dicoding.compose.jetpackprime.model.Cast
import dicoding.compose.jetpackprime.model.Movie
import dicoding.compose.jetpackprime.presentation.component.ActorCard
import dicoding.compose.jetpackprime.presentation.component.Text
import dicoding.compose.jetpackprime.presentation.component.TextType
import dicoding.compose.jetpackprime.presentation.theme.JetpackPrimeTheme
import dicoding.compose.jetpackprime.util.gradientBackground

@Composable
fun DetailMovieScreen(
    idMovie: Int,
    viewModel: DetailMovieViewModel,
    onBackPress: () -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.getDetail(idMovie)
        viewModel.isFavorite(idMovie)
    }

    val tintState by viewModel.tintState

    viewModel.movieState.collectAsState().value.let { state ->
        when (state) {
            is DetailMovieViewModel.MovieState.Success -> {
                Box(modifier = Modifier.fillMaxSize()) {
                    AsyncImage(
                        model = state.data.poster,
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.FillWidth
                    )
                    ContentDetail(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(
                                LocalConfiguration.current.screenHeightDp.dp * 4 / 5
                            )
                            .align(Alignment.BottomCenter),
                        data = state.data
                    )

                    IconButton(
                        onClick = onBackPress,
                        modifier = Modifier.padding(top = 16.dp, start = 8.dp)

                    ) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White,
                            modifier = Modifier.size(25.dp)
                        )
                    }

                    Column(
                        modifier = Modifier
                            .padding(top = 16.dp, end = 12.dp)
                            .align(Alignment.TopEnd)
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(Color.White),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        IconButton(
                            onClick = {
                                viewModel.actionFavorite(idMovie = idMovie)
                            },
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Favorite,
                                contentDescription = "favorite",
                                tint = tintState,
                                modifier = Modifier.size(25.dp)
                            )
                        }
                    }
                }
            }
            else -> Unit
        }
    }


}

@Composable
fun ContentDetail(
    modifier: Modifier = Modifier,
    data: Movie
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
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
            .padding(top = 200.dp, bottom = 40.dp)
    ) {
        Text(
            text = data.title,
            type = TextType.TITLE,
            textAlign = TextAlign.Start,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = data.year,
            type = TextType.CAPTION,
        )
        Text(
            text = data.overview,
            type = TextType.BODY2,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        Text(
            text = "Casts",
            type = TextType.BODY1,
        )
        ListActor(
            casts = data.cast,
        )
    }
}

@Preview
@Composable
private fun ContentDetailPreview() {
    JetpackPrimeTheme {
        ContentDetail(
            modifier = Modifier
                .fillMaxWidth()
                .height(
                    LocalConfiguration.current.screenHeightDp.dp * 3 / 4
                ),
            data = Movie(
                id = 1,
                title = "",
                poster = "",
                overview = "",
                year = "",
                cast = listOf(
                    Cast(
                        id = 1,
                        image = "",
                        cast = "",
                        name = ""
                    )
                )
            )
        )
    }
}


@Composable
fun ListActor(
    modifier: Modifier = Modifier,
    casts: List<Cast>
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.height(150.dp)
    ) {
        items(casts, key = { it.id }) { element ->
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
            Cast(
                1,
                "https://www.themoviedb.org/t/p/w138_and_h175_face/fBEucxECxGLKVHBznO0qHtCGiMO.jpg",
                "Benedict",
                "Doctor Strange"
            ),
            Cast(
                2,
                "https://www.themoviedb.org/t/p/w138_and_h175_face/fBEucxECxGLKVHBznO0qHtCGiMO.jpg",
                "Benedict",
                "Doctor Strange"
            ),
            Cast(
                3,
                "https://www.themoviedb.org/t/p/w138_and_h175_face/fBEucxECxGLKVHBznO0qHtCGiMO.jpg",
                "Benedict",
                "Doctor Strange"
            ),
            Cast(
                4,
                "https://www.themoviedb.org/t/p/w138_and_h175_face/fBEucxECxGLKVHBznO0qHtCGiMO.jpg",
                "Benedict",
                "Doctor Strange"
            ),
            Cast(
                5,
                "https://www.themoviedb.org/t/p/w138_and_h175_face/fBEucxECxGLKVHBznO0qHtCGiMO.jpg",
                "Benedict",
                "Doctor Strange"
            ),
            Cast(
                6,
                "https://www.themoviedb.org/t/p/w138_and_h175_face/fBEucxECxGLKVHBznO0qHtCGiMO.jpg",
                "Benedict",
                "Doctor Strange"
            ),
        )
    )
}