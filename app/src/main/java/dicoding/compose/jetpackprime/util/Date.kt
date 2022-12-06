package dicoding.compose.jetpackprime.util

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*
import java.util.Date

object Date {
    @SuppressLint("SimpleDateFormat")
    fun String.toGetYear():String{
        val date = SimpleDateFormat("yyyy-MM-dd", Locale("IND","ID")).parse(this)
        return SimpleDateFormat("yyyy").format(date as Date)
    }
}