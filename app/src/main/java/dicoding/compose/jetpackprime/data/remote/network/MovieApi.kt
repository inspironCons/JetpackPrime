package dicoding.compose.jetpackprime.data.remote.network

import dicoding.compose.jetpackprime.data.remote.network.dto.CastMovieDto
import dicoding.compose.jetpackprime.data.remote.network.dto.DetailMovieDto
import dicoding.compose.jetpackprime.util.General
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {
    @GET("movie/{id}")
    suspend fun getDetailMovie(
        @Path("id") id:Int,
        @Query("api_key") apiKey:String = General.API_KEY,
        @Query("language")language:String = General.LANGUAGE
    ):DetailMovieDto

    @GET("movie/{id}/credits")
    suspend fun getCastById(
        @Path("id") id:Int,
        @Query("api_key") apiKey:String = General.API_KEY,
        @Query("language")language:String = General.LANGUAGE,
    ): CastMovieDto
}