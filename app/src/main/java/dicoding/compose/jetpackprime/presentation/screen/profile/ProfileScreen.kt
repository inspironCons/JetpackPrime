package dicoding.compose.jetpackprime.presentation.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dicoding.compose.jetpackprime.R
import dicoding.compose.jetpackprime.model.Movies
import dicoding.compose.jetpackprime.presentation.component.MessageState
import dicoding.compose.jetpackprime.presentation.component.MovieCard
import dicoding.compose.jetpackprime.presentation.component.Text
import dicoding.compose.jetpackprime.presentation.component.TextType

@Composable
fun ProfileScreen(
    onBackPress: () -> Unit = {},
    viewModel: ProfileViewModel,
    navigateToDetail: (Int) -> Unit
) {
    LaunchedEffect(Unit){
        viewModel.getListFavorite()
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 80.dp)
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "photo_profile_ramdhon",
                    modifier = Modifier
                        .padding(8.dp)
                        .size(80.dp)
                        .clip(CircleShape)
                        .border(
                            width = 2.dp,
                            color = MaterialTheme.colors.primary,
                            shape = CircleShape
                        )
                )
                Column {
                    Text(
                        text = stringResource(id = R.string.my_name),
                        type = TextType.TITLE,
                        modifier = Modifier.padding(vertical = 2.dp)
                    )
                    Text(
                        text = stringResource(id = R.string.my_email),
                        type = TextType.BODY1,
                        modifier = Modifier.padding(vertical = 2.dp)
                    )

                }
            }

            Text(text = "My Favorite Movie", type = TextType.TITLE)

            viewModel.movieState.collectAsState().value.let { state->
                when(state){
                    is ProfileViewModel.FavoriteState.Success->{
                        MovieFavorite(
                            list = state.data,
                            navigateToDetail = navigateToDetail,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                    is ProfileViewModel.FavoriteState.Error->{
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
                    else->Unit
                }
            }
        }
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
    }
}

@Composable
fun MovieFavorite(
    list: List<Movies>,
    navigateToDetail: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        modifier = modifier
    ) {
        items(list, key = { it.id }) { element ->
            MovieCard(
                data = element,
                modifier = Modifier.clickable { navigateToDetail(element.id) }
            )
        }
    }
}