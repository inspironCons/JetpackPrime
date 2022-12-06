package dicoding.compose.jetpackprime.presentation.screen.detail_movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dicoding.compose.jetpackprime.domain.use_case.IDetailMovieUseCase
import dicoding.compose.jetpackprime.model.Movie
import dicoding.compose.jetpackprime.presentation.screen.home.HomeViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class DetailMovieViewModel @Inject constructor(
    private val useCase: IDetailMovieUseCase
):ViewModel() {

    private val _movieState:MutableStateFlow<MovieState> = MutableStateFlow(MovieState.Empty)
    val movieState:StateFlow<MovieState> = _movieState

    sealed class MovieState{
        data class Success(val data:Movie):MovieState()
        data class Error(val msg:String):MovieState()
        object Loading:MovieState()
        object Empty:MovieState()
    }

    fun getDetail(id:Int) = viewModelScope.launch {
        _movieState.value = MovieState.Loading
        useCase.getDetailMovieById(id).collect{result->
            if(result.isSuccess){
                val data = result.getOrNull()
                if(data !=null){
                    _movieState.value = MovieState.Success(data)
                }else{
                    _movieState.value = MovieState.Error("Data film kosong")
                }
            }else{
                when(val e = result.exceptionOrNull()){
                    is HttpException -> _movieState.value = MovieState.Error("Sedang dalam gangguan, coba lagi beberapa saat")
                    is RuntimeException-> _movieState.value = MovieState.Error(e.localizedMessage?:"Unknown Exception")
                    else-> HomeViewModel.MoviesState.Error(e?.localizedMessage?:"Unknown Exception")
                }
            }
        }
    }
}