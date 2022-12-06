package dicoding.compose.jetpackprime.presentation.component

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun FloatingButton(
    image:ImageVector,
    contentDescriptor: String,
    tint: Color,
    onClickAction: ()-> Unit
){
    FloatingActionButton(
        onClick = onClickAction,
        backgroundColor = MaterialTheme.colors.primary,
    ) {
        Icon(
            imageVector = image,
            contentDescription = contentDescriptor,
            tint = tint
        )
    }
}