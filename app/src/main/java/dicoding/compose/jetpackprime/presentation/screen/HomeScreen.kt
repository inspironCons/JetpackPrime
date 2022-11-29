package dicoding.compose.jetpackprime.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dicoding.compose.jetpackprime.R
import dicoding.compose.jetpackprime.model.Movies
import dicoding.compose.jetpackprime.presentation.JetpackPrimeApp
import dicoding.compose.jetpackprime.presentation.component.MovieCard
import dicoding.compose.jetpackprime.presentation.component.SearchBar
import dicoding.compose.jetpackprime.presentation.component.Text
import dicoding.compose.jetpackprime.presentation.component.TextType
import dicoding.compose.jetpackprime.presentation.theme.JetpackPrimeTheme
import dicoding.compose.jetpackprime.util.General

@Composable
fun HomeScreen() {
    JetpackPrimeApp { innerPadding->
        Column(modifier = Modifier
            .padding(innerPadding)
            .padding(12.dp)
            .padding(top = 36.dp)
        ) {
            ContentWrap(title = stringResource(id = R.string.search_movie_title)){
                SearchBar()
            }

            ContentWrap(
                title = stringResource(id = R.string.top_movies),
                modifier = Modifier.padding(vertical = 8.dp)
            ){
                FavoriteMovieSection(
                    list = General.dummylist
                )
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    JetpackPrimeTheme {
        HomeScreen()
    }
}

@Composable
fun ContentWrap(
    modifier: Modifier = Modifier,
    title:String? = null,
    content:@Composable () -> Unit = {}
){
    Column(modifier = modifier.fillMaxWidth()) {
        if(title != null) Text(text =title, type = TextType.SUBTITLE, modifier = Modifier.padding(bottom = 16.dp))
        content()
    }
}

@Composable
fun FavoriteMovieSection(
    list:List<Movies>
) {
    LazyColumn{
        items(list, key = {it.id}){element->
            MovieCard(
                data = element
            )
        }
    }
}

@Preview
@Composable
fun FavoriteMovieSectionPreview(){
    JetpackPrimeTheme {

    }
}

