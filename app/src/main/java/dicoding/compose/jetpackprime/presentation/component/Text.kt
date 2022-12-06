package dicoding.compose.jetpackprime.presentation.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import dicoding.compose.jetpackprime.presentation.theme.JetpackPrimeTheme
import androidx.compose.material.Text as MText

enum class TextType {
    TITLE,
    SUBTITLE,
    BODY1,
    BODY2,
    CAPTION
}

private const val dummyText = "Lorem ipsum dolor sit amet"

@Composable
fun Text(
    modifier: Modifier = Modifier,
    text: String,
    type: TextType = TextType.BODY1,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle? = null
) {
    val styleText = style
        ?: when (type) {
            TextType.TITLE ->
                MaterialTheme.typography.h5
            TextType.SUBTITLE ->
                MaterialTheme.typography.subtitle1
            TextType.BODY1 ->
                MaterialTheme.typography.body1
            TextType.BODY2 ->
                MaterialTheme.typography.body2
            TextType.CAPTION ->
                MaterialTheme.typography.caption
        }

    MText(
        text = text,
        modifier = modifier,
        style = styleText,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
    )
}

@Preview
@Composable
fun TextTitlePreview() {
    JetpackPrimeTheme {
        Text(text = dummyText, type = TextType.TITLE, modifier = Modifier.fillMaxWidth())
    }
}

@Preview
@Composable
fun TextSubtitlePreview() {
    JetpackPrimeTheme {
        Text(text = dummyText, type = TextType.SUBTITLE, modifier = Modifier.fillMaxWidth())
    }
}

@Preview
@Composable
fun TextBody1Preview() {
    JetpackPrimeTheme {
        Text(text = dummyText, type = TextType.BODY1, modifier = Modifier.fillMaxWidth())
    }
}

@Preview
@Composable
fun TextBody2Preview() {
    JetpackPrimeTheme {
        Text(text = dummyText, type = TextType.BODY2, modifier = Modifier.fillMaxWidth())
    }
}

@Preview
@Composable
fun TextCaptionPreview() {
    JetpackPrimeTheme {
        Text(text = dummyText, type = TextType.CAPTION, modifier = Modifier.fillMaxWidth())
    }
}