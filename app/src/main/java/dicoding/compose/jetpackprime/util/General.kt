package dicoding.compose.jetpackprime.util

import androidx.compose.ui.graphics.Color
import dicoding.compose.jetpackprime.BuildConfig
import dicoding.compose.jetpackprime.model.Movies

object  General {
    private val randomColor = listOf(
        listOf(Color(0xFFFF2E2E), Color(0xFFE08939)),
        listOf(Color(0xFF004D40), Color(0xFF009688)),
        listOf(Color(0xFFB71C1C), Color(0xFFF44336)),
        listOf(Color(0xFF004599), Color(0xFF1D91EA)),
        listOf(Color(0xFF2900BD), Color(0xFF732DDC)),
        listOf(Color(0xFFC01619), Color(0xFFFC4133)),
        listOf(Color(0xFF005900), Color(0xFF42A834)),
        listOf(Color(0xFF8B8027), Color(0xFFD5E220)),
        listOf(Color(0xFF004C35), Color(0xFF149579)),
        listOf(Color(0xFF414141), Color(0xFF747474)),
)

    fun generateColor():List<Color>{
        val rand = (0..9).random()
        return randomColor[rand]
    }

    const val BASE_URL = BuildConfig.baseUrl
    const val IMAGE_URL = BuildConfig.imageUrl
    const val LANGUAGE = "en-EN"
    const val REGION = "ID"

}