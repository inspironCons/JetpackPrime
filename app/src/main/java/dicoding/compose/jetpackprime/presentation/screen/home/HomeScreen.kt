package dicoding.compose.jetpackprime.presentation.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dicoding.compose.jetpackprime.R
import dicoding.compose.jetpackprime.model.Movies
import dicoding.compose.jetpackprime.presentation.component.*

class SearchBarState(initialValue: String) {
    var search by mutableStateOf(initialValue)
}

@Composable
fun rememberSearchState(input: String): SearchBarState = remember(input) {
    SearchBarState(input)
}

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    setProfileClick: ((() -> Unit)?) -> Unit,
    navigateToDetail: (Int) -> Unit,
    navigateToProfile: () -> Unit
) {
    val query by viewModel.query
    val type by viewModel.type
    LaunchedEffect(Unit) {
        viewModel.searchMovie(type = type)
        setProfileClick{
            navigateToProfile()
        }
    }

    Column(
        modifier = Modifier
            .padding(12.dp)
            .padding(top = 36.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ContentWrap(
            title = stringResource(id = R.string.search_movie_title)
        ) {
            SearchBar(query = query) { value->
                viewModel.setQuery(value)
                if (value.length > 3) {
                    viewModel.searchMovie(
                        type = TypeState.Search
                    )
                }

                if (value.isEmpty()) {
                    viewModel.searchMovie(type = TypeState.Trending)
                }
            }
        }

        viewModel.movieState.collectAsState().value.let { state ->
            when (state) {
                is HomeViewModel.MoviesState.Success -> {
                    when (state.type) {
                        TypeState.Search -> {
                            ListMovie(
                                list = state.list
                            ) {
                                navigateToDetail(it)
                            }
                        }
                        TypeState.Trending -> {
                            TrendingListMovie(
                                state.list
                            ) {
                                navigateToDetail(it)
                            }
                        }
                    }
                }
                is HomeViewModel.MoviesState.Error -> {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        MessageState(
                            image = R.drawable.ic_error_state,
                            message = state.msg,
                        )
                    }
                }
                else -> Unit
            }
        }
    }
}

@Composable
fun TrendingListMovie(
    list: List<Movies>,
    modifier: Modifier = Modifier,
    navigateToDetail: (Int) -> Unit
) {
    ContentWrap(
        title = stringResource(id = R.string.top_movies),
        modifier = modifier.padding(vertical = 4.dp)
    ) {
        FavoriteMovieSection(
            list = list
        ) {
            navigateToDetail(it)
        }
    }
}

@Composable
fun ListMovie(
    list: List<Movies>,
    modifier: Modifier = Modifier,
    navigateToDetail: (Int) -> Unit
) {
    ContentWrap(
        modifier = modifier.padding(vertical = 4.dp)
    ) {
        SearchMovieSection(
            list = list
        ) {
            navigateToDetail(it)
        }
    }
}


@Composable
fun ContentWrap(
    modifier: Modifier = Modifier,
    title: String? = null,
    content: @Composable () -> Unit = {}
) {
    Column(modifier = modifier.fillMaxWidth()) {
        if (title != null) Text(
            text = title,
            type = TextType.SUBTITLE,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        content()
    }
}

@Composable
fun FavoriteMovieSection(
    list: List<Movies>,
    navigateToDetail: (Int) -> Unit
) {
    LazyColumn() {
        items(list, key = { it.id }) { element ->
            TrendingMovieCard(
                data = element,
                modifier = Modifier.clickable { navigateToDetail(element.id) }
            )
        }
    }
}

@Composable
fun SearchMovieSection(
    list: List<Movies>,
    navigateToDetail: (Int) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(list, key = { it.id }) { element ->
            MovieCard(
                data = element,
                modifier = Modifier.clickable { navigateToDetail(element.id) }
            )
        }
    }
}