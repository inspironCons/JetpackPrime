package dicoding.compose.jetpackprime.domain.use_case

import dicoding.compose.jetpackprime.domain.repository.IFavoriteRepository
import dicoding.compose.jetpackprime.model.Movies
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface IProfileUseCase{
    fun getListFavorite():Flow<List<Movies>>
}

class ProfileUseCaseImpl @Inject constructor(
    private val repo:IFavoriteRepository
):IProfileUseCase{
    override fun getListFavorite(): Flow<List<Movies>> = repo.getAllFavorite()
}