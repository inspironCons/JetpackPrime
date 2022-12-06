package dicoding.compose.jetpackprime.util

import java.text.SimpleDateFormat
import java.util.*
import java.util.Date

object Date {
    fun String.toGetYear():String{
        val date = SimpleDateFormat("yyyy-MM-dd", Locale("IND","ID")).parse(this)
        return SimpleDateFormat("yyyy").format(date as Date)
    }
}