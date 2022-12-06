package dicoding.compose.jetpackprime.presentation.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dicoding.compose.jetpackprime.R
import dicoding.compose.jetpackprime.presentation.component.Text
import dicoding.compose.jetpackprime.presentation.component.TextType
import dicoding.compose.jetpackprime.presentation.theme.JetpackPrimeTheme

@Composable
fun ProfileScree(
    onBackPress: () -> Unit = {}
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "photo_profile_ramdhon",
                modifier = Modifier
                    .padding(top = 100.dp)
                    .size(200.dp)
                    .clip(CircleShape)
                    .border(
                        width = 2.dp,
                        color = MaterialTheme.colors.primary,
                        shape = CircleShape
                    )
            )
            Text(
                text = stringResource(id = R.string.my_name),
                type = TextType.TITLE,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Text(
                text = stringResource(id = R.string.my_email),
                type = TextType.BODY1,
                modifier = Modifier.padding(vertical = 8.dp)
            )
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

@Preview
@Composable
fun ProfileScreenPreview() {
    JetpackPrimeTheme {
        ProfileScree()
    }
}