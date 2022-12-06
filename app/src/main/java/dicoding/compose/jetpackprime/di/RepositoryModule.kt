package dicoding.compose.jetpackprime.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dicoding.compose.jetpackprime.data.repository.FavoriteRepositoryImpl
import dicoding.compose.jetpackprime.data.repository.MovieRepositoryImpl
import dicoding.compose.jetpackprime.domain.repository.IFavoriteRepository
import dicoding.compose.jetpackprime.domain.repository.IMovieRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideMovieRepository(movieRepositoryImpl: MovieRepositoryImpl):IMovieRepository

    @Binds
    abstract fun provideFavoriteRepository(favoriteRepositoryImpl: FavoriteRepositoryImpl):IFavoriteRepository
}