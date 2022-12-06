package dicoding.compose.jetpackprime.data.remote.network.dto

import com.google.gson.annotations.SerializedName
import dicoding.compose.jetpackprime.model.Cast
import dicoding.compose.jetpackprime.model.Movie
import dicoding.compose.jetpackprime.util.Date.toGetYear
import dicoding.compose.jetpackprime.util.General

data class DetailMovieDto(
    @SerializedName("id") var id: Int,
    @SerializedName("title") var title: String,
    @SerializedName("overview") var overview: String,
    @SerializedName("poster_path") var posterPath: String,
    @SerializedName("release_date") var releaseDate: String
){
    fun toMovie() = Movie(
        id = id,
        title = title,
        overview = overview,
        poster = General.IMAGE_URL+posterPath,
        year = if(releaseDate.isNotEmpty())releaseDate.toGetYear() else releaseDate
    )
}

data class CastMovieDto(
    @SerializedName("cast") var cast: List<CastsDto>
){
    fun toCast():List<Cast>{
        val result = arrayListOf<Cast>()
        cast.map { element->
            result.add(
                Cast(
                    id = element.id,
                    image = General.IMAGE_URL+element.picture,
                    cast = element.name,
                    name = element.character
                )
            )
        }
        return result
    }
}

data class CastsDto(
    @SerializedName("id") var id: Int,
    @SerializedName("name") var name: String,
    @SerializedName("character") var character: String,
    @SerializedName("profile_path") var picture: String,
)