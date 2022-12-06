package dicoding.compose.jetpackprime.domain.repository

import dicoding.compose.jetpackprime.model.Movie
import dicoding.compose.jetpackprime.model.Movies
import kotlinx.coroutines.flow.Flow

interface IMovieRepository{
    fun trendingMovies(): Flow<Result<List<Movies>>>
    fun searchMovie(search:String):Flow<Result<List<Movies>>>
    fun detailMovie(id:Int):Flow<Result<Movie>>
}