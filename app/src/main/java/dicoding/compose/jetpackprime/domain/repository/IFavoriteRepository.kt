package dicoding.compose.jetpackprime.domain.repository

import dicoding.compose.jetpackprime.model.Movies
import kotlinx.coroutines.flow.Flow


interface IFavoriteRepository {
    fun addFavorite(movie:Movies): Flow<Result<Boolean>>
    fun removeFavorite(id:Int):Flow<Result<Boolean>>
    fun isFavorite(id:Int):Flow<Result<Boolean>>
    fun getAllFavorite():Flow<List<Movies>>
}