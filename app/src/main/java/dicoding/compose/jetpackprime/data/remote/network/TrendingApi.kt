package dicoding.compose.jetpackprime.data.remote.network

import dicoding.compose.jetpackprime.data.remote.network.dto.MoviesDto
import dicoding.compose.jetpackprime.util.General
import retrofit2.http.GET
import retrofit2.http.Query

interface TrendingApi {
    @GET("trending/movie/week")
    suspend fun getTrendingMovieOnThisWeek(
        @Query("api_key") apiKey:String = General.API_KEY,
        @Query("language")language:String = General.LANGUAGE,
        @Query("region")region:String = General.REGION
    ): MoviesDto
}