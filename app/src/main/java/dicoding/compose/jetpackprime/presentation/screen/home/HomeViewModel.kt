package dicoding.compose.jetpackprime.presentation.screen.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dicoding.compose.jetpackprime.domain.use_case.IHomeUseCase
import dicoding.compose.jetpackprime.model.Movies
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: IHomeUseCase
):ViewModel() {

    private val _movieState:MutableStateFlow<MoviesState> = MutableStateFlow(MoviesState.Empty)
    val movieState:StateFlow<MoviesState> get() = _movieState


    private val _searchQuery = mutableStateOf("")
    val query get() = _searchQuery

    private val _type = mutableStateOf(TypeState.Trending)
    val type get() = _type



    sealed class MoviesState{
        data class Success(val list:List<Movies>,val type:TypeState):MoviesState()
        data class Error(val msg:String):MoviesState()
        object Loading:MoviesState()
        object Empty:MoviesState()
    }

    fun setQuery(search:String){
        _searchQuery.value = search
    }
    fun searchMovie(type:TypeState) = viewModelScope.launch {
        _movieState.value = MoviesState.Loading
        _type.value = type
        when(type){
            TypeState.Trending->{
                useCase.getTrendingMovies().collect{result->
                    if(result.isSuccess){
                        val list = result.getOrNull()
                        if(list != null){
                            _movieState.value = MoviesState.Success(list,type)
                        }else{
                            _movieState.value = MoviesState.Error("Data film kosong...")
                        }
                    }else{
                        when(val e = result.exceptionOrNull()){
                            is HttpException-> _movieState.value = MoviesState.Error("Sedang dalam gangguan, coba lagi beberapa saat")
                            is RuntimeException-> _movieState.value = MoviesState.Error(e.localizedMessage?:"Unknown Exception")
                            else->MoviesState.Error(e?.localizedMessage?:"Unknown Exception")
                        }
                    }
                }
            }
            TypeState.Search->{
                useCase.getMoviesBySearch(query.value).collect{ result->
                    if(result.isSuccess){
                        val list = result.getOrNull()
                        if(list != null){
                            if(list.isNotEmpty()){
                                _movieState.value = MoviesState.Success(list,type)
                            }else{
                                _movieState.value = MoviesState.Error("Kata kunci yang anda cari tidak di temukan...")
                            }
                        }else{
                            _movieState.value = MoviesState.Error("Data film kosong...")

                        }
                    }else{
                        when(val e = result.exceptionOrNull()){
                            is HttpException-> _movieState.value = MoviesState.Error("Sedang dalam gangguan, coba lagi beberapa saat")
                            is RuntimeException-> _movieState.value = MoviesState.Error(e.message?:"Unknown Exception")
                            else->MoviesState.Error(e?.message?:"Unknown Exception")
                        }
                    }
                }
            }
        }
    }

}

enum class TypeState{
    Trending,
    Search
}