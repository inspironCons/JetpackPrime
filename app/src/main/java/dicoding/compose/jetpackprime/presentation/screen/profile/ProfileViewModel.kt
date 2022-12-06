package dicoding.compose.jetpackprime.presentation.screen.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dicoding.compose.jetpackprime.domain.use_case.IProfileUseCase
import dicoding.compose.jetpackprime.model.Movies
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val useCase: IProfileUseCase
):ViewModel() {
    private val _movieState:MutableStateFlow<FavoriteState> = MutableStateFlow(FavoriteState.Empty)
    val movieState:StateFlow<FavoriteState> = _movieState
    sealed class FavoriteState{
        data class Success(val data:List<Movies>):FavoriteState()
        data class Error(val msg:String):FavoriteState()
        object Loading:FavoriteState()
        object Empty:FavoriteState()
    }

    fun getListFavorite() = viewModelScope.launch {
        _movieState.value = FavoriteState.Loading
        useCase.getListFavorite().collect{list->
            if(list.isNotEmpty()){
                _movieState.value = FavoriteState.Success(list)
            }else{
                _movieState.value = FavoriteState.Error("There's no favorite movie data yet")
            }
        }
    }
}