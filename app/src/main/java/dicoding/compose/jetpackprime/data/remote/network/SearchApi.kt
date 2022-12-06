package dicoding.compose.jetpackprime.data.remote.network

import dicoding.compose.jetpackprime.data.remote.network.dto.MoviesDto
import dicoding.compose.jetpackprime.util.General
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {
    @GET("search/movie")
    suspend fun searchMovie(
        @Query("api_key") apiKey:String = General.API_KEY,
        @Query("query") search:String,
        @Query("language")language:String = General.LANGUAGE,
        @Query("region")region:String = General.REGION
    ): MoviesDto
}