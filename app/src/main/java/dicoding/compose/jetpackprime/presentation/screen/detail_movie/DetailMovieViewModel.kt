package dicoding.compose.jetpackprime.presentation.screen.detail_movie

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dicoding.compose.jetpackprime.domain.use_case.IDetailMovieUseCase
import dicoding.compose.jetpackprime.model.Movie
import dicoding.compose.jetpackprime.presentation.screen.home.HomeViewModel
import dicoding.compose.jetpackprime.presentation.theme.DustyPink
import dicoding.compose.jetpackprime.presentation.theme.W100
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

    private val _tintState = mutableStateOf(W100)
    val tintState get() = _tintState

    private val isFavorite = mutableStateOf(false)
    private var movie: Movie? = null
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
                    movie = data
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

    fun isFavorite(id:Int) = viewModelScope.launch {
        useCase.isFavoriteMovie(id).collect{result->
            if(result.isSuccess){
                val isSuccess = result.getOrNull()!!
                _tintState.value = if(isSuccess) DustyPink else Black
                isFavorite.value = isSuccess
            }else{
                _tintState.value = Black
                isFavorite.value = false
            }
        }
    }

    fun actionFavorite(idMovie: Int) = viewModelScope.launch {
        if(!isFavorite.value){
            val data = movie!!.toMovies()
            useCase.addFavorite(data).collect{
                isFavorite(idMovie)
            }
        }else{
            useCase.removeFavorite(idMovie).collect{
                isFavorite(idMovie)
            }
        }
    }
}