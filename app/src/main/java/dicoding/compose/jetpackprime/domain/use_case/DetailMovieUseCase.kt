package dicoding.compose.jetpackprime.domain.use_case

import dicoding.compose.jetpackprime.domain.repository.IFavoriteRepository
import dicoding.compose.jetpackprime.domain.repository.IMovieRepository
import dicoding.compose.jetpackprime.model.Movie
import dicoding.compose.jetpackprime.model.Movies
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface IDetailMovieUseCase{
    fun getDetailMovieById(id:Int):Flow<Result<Movie>>
    fun isFavoriteMovie(id:Int):Flow<Result<Boolean>>
    fun addFavorite(data:Movies):Flow<Result<Boolean>>
    fun removeFavorite(id:Int):Flow<Result<Boolean>>
}

class DetailMovieUseCaseImpl @Inject constructor(
    private val movieRepo:IMovieRepository,
    private val favoriteRepo:IFavoriteRepository
):IDetailMovieUseCase{
    override fun getDetailMovieById(id: Int): Flow<Result<Movie>> = movieRepo.detailMovie(id)

    override fun isFavoriteMovie(id: Int): Flow<Result<Boolean>>  = favoriteRepo.isFavorite(id)

    override fun addFavorite(data: Movies): Flow<Result<Boolean>> = favoriteRepo.addFavorite(data)

    override fun removeFavorite(id: Int): Flow<Result<Boolean>> = favoriteRepo.removeFavorite(id)
}