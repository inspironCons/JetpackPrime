package dicoding.compose.jetpackprime.model

data class Movie(
    val id:Int,
    val title:String,
    val poster:String,
    val overview:String,
    val year:String,
    var cast:List<Cast> = arrayListOf()
){
    fun toMovies() = Movies(
        id = id,
        image = poster,
        year = year,
        number = 0,
        title = title
    )
}