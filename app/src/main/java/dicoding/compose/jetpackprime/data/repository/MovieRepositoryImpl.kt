package dicoding.compose.jetpackprime.data.repository

import dicoding.compose.jetpackprime.data.remote.network.MovieApi
import dicoding.compose.jetpackprime.data.remote.network.SearchApi
import dicoding.compose.jetpackprime.data.remote.network.TrendingApi
import dicoding.compose.jetpackprime.domain.repository.IMovieRepository
import dicoding.compose.jetpackprime.model.Movie
import dicoding.compose.jetpackprime.model.Movies
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val trendingApi: TrendingApi,
    private val searchApi: SearchApi,
    private val movieApi: MovieApi
):IMovieRepository {
    override fun trendingMovies(): Flow<Result<List<Movies>>> = flow {
        try {
            val trending = trendingApi.getTrendingMovieOnThisWeek()
            emit(Result.success(trending.toMovies()))
        }catch (e:HttpException){
            emit(Result.failure(HttpException(e.response()!!)))
        }catch (e:Exception){
            emit(Result.failure(RuntimeException("Exception on trending movies",e.cause)))
        }
    }

    override fun searchMovie(search: String): Flow<Result<List<Movies>>> = flow {
        try {
            val movies = searchApi.searchMovie(search = search)
            emit(Result.success(movies.toMovies()))
        }catch (e:HttpException){
            emit(Result.failure(HttpException(e.response()!!)))
        }catch (e:Exception){
            e.printStackTrace()
            emit(Result.failure(RuntimeException("Exception on search movies",e.cause)))
        }
    }

    override fun detailMovie(id: Int): Flow<Result<Movie>> = flow {
        try {
            val header = movieApi.getDetailMovie(id = id)
            val cast = movieApi.getCastById(id = id)
            val movie = header.toMovie()
            movie.cast = cast.toCast()

            emit(Result.success(movie))
        }catch (e:HttpException){
            emit(Result.failure(HttpException(e.response()!!)))
        }catch (e:Exception){
            emit(Result.failure(RuntimeException("Exception on trending movies",e.cause)))
        }
    }
}