package dicoding.compose.jetpackprime.domain.use_case

import dicoding.compose.jetpackprime.domain.repository.IMovieRepository
import dicoding.compose.jetpackprime.model.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface IDetailMovieUseCase{
    fun getDetailMovieById(id:Int):Flow<Result<Movie>>
}

class DetailMovieUseCaseImpl @Inject constructor(
    private val movieRepo:IMovieRepository
):IDetailMovieUseCase{
    override fun getDetailMovieById(id: Int): Flow<Result<Movie>> = movieRepo.detailMovie(id)
}