package dicoding.compose.jetpackprime.model

data class Movies(
    val id:Int,
    val image:String?=null,
    val number:Int,
    val title:String,
    val year:String
)
