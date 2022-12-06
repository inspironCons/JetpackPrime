package dicoding.compose.jetpackprime.presentation.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dicoding.compose.jetpackprime.R
import dicoding.compose.jetpackprime.presentation.screen.home.SearchBarState
import dicoding.compose.jetpackprime.presentation.screen.home.rememberSearchState
import dicoding.compose.jetpackprime.presentation.theme.JetpackPrimeTheme
import dicoding.compose.jetpackprime.presentation.theme.PrimeShape

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    query:String,
    searchData:(String)->Unit = {}
) {
    TextField(
        modifier = modifier
            .fillMaxWidth()
            .clip(PrimeShape)
            .border(width = 2.dp, shape = PrimeShape, color = Color.White),
        value = query,
        onValueChange = searchData,
        placeholder = {
            Text(text = stringResource(id = R.string.search_movie), type = TextType.BODY2)
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface,
            disabledIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor =  Color.Transparent
        ),
        singleLine = true
    )
}

@Preview
@Composable
fun SearchBarPreview() {
    JetpackPrimeTheme {
        SearchBar(query = "")
    }
}