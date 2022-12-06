package dicoding.compose.jetpackprime.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dicoding.compose.jetpackprime.domain.use_case.*

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {
    @Binds
    abstract fun provideHomeUseCase(useCaseImpl: HomeUseCaseImpl):IHomeUseCase

    @Binds
    abstract fun provideDetailMovieUseCase(useCaseImpl: DetailMovieUseCaseImpl):IDetailMovieUseCase

    @Binds
    abstract fun provideProfileUseCase(useCaseImpl: ProfileUseCaseImpl):IProfileUseCase
}