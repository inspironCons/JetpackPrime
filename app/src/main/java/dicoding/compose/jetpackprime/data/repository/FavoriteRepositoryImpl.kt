package dicoding.compose.jetpackprime.data.repository

import dicoding.compose.jetpackprime.domain.repository.IFavoriteRepository
import dicoding.compose.jetpackprime.model.Movies
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FavoriteRepositoryImpl @Inject constructor():IFavoriteRepository {
    private val data = mutableListOf<Movies>()
    override fun addFavorite(movie:Movies): Flow<Result<Boolean>> = flow {
        try {
            data.add(movie)
            emit(Result.success(true))
        }catch (e:Exception){
            emit(Result.failure(e))
        }
    }

    override fun removeFavorite(id:Int): Flow<Result<Boolean>>  = flow {
        try {
            val temp = mutableListOf<Movies>()
            val filter = data.filter { it.id != id }
            temp.addAll(filter)
            data.clear()
            data.addAll(temp)
            emit(Result.success(true))
        }catch (e:Exception){
            emit(Result.failure(e))
        }
    }

    override fun isFavorite(id:Int): Flow<Result<Boolean>> = flow {
        try {
            val find = data.find { it.id == id }
            if(find != null){
                emit(Result.success(true))
            }else{
                emit(Result.success(false))
            }
        }catch (e:Exception){
            emit(Result.failure(e))
        }
    }

    override fun getAllFavorite(): Flow<List<Movies>> = flowOf(data.toList())
}