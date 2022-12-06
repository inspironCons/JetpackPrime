package dicoding.compose.jetpackprime.model

data class Movie(
    val id:Int,
    val title:String,
    val poster:String,
    val overview:String,
    val year:String,
    var cast:List<Cast> = arrayListOf()
)