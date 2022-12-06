package dicoding.compose.jetpackprime.domain.use_case

import dicoding.compose.jetpackprime.domain.repository.IMovieRepository
import dicoding.compose.jetpackprime.model.Movies
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface IHomeUseCase{
    fun getTrendingMovies():Flow<Result<List<Movies>>>
    fun getMoviesBySearch(search:String):Flow<Result<List<Movies>>>
}

class HomeUseCaseImpl @Inject constructor(
    private val movieRepo:IMovieRepository
):IHomeUseCase {
    override fun getTrendingMovies(): Flow<Result<List<Movies>>> = movieRepo.trendingMovies()
    override fun getMoviesBySearch(search: String): Flow<Result<List<Movies>>> = movieRepo.searchMovie(search)
}