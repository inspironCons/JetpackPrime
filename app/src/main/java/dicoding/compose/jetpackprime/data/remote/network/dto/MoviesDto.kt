package dicoding.compose.jetpackprime.data.remote.network.dto

import com.google.gson.annotations.SerializedName
import dicoding.compose.jetpackprime.model.Movies
import dicoding.compose.jetpackprime.util.Date.toGetYear
import dicoding.compose.jetpackprime.util.General

data class MoviesDto(
    @SerializedName("results") var results: List<MoviesResponse> = arrayListOf()
){
    fun toMovies():List<Movies>{
        val movies:ArrayList<Movies> = arrayListOf()
        results.mapIndexed { index, element ->
            movies.add(
                Movies(
                    id = element.id,
                    image = General.IMAGE_URL+element.posterPath,
                    number = index+1,
                    title = element.title,
                    year = if(element.releaseDate.isNotEmpty())element.releaseDate.toGetYear() else element.releaseDate
                )
            )
        }
        return movies
    }
}

data class MoviesResponse(
    @SerializedName("id") var id: Int,
    @SerializedName("poster_path") var posterPath: String?,
    @SerializedName("release_date") var releaseDate: String,
    @SerializedName("title") var title: String,
)