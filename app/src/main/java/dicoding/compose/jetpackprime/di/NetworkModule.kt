package dicoding.compose.jetpackprime.di

import com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dicoding.compose.jetpackprime.BuildConfig
import dicoding.compose.jetpackprime.data.remote.network.MovieApi
import dicoding.compose.jetpackprime.data.remote.network.SearchApi
import dicoding.compose.jetpackprime.data.remote.network.TrendingApi
import dicoding.compose.jetpackprime.util.General
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private val flipperPlugin = NetworkFlipperPlugin()

    private val client = OkHttpClient.Builder()
        .addNetworkInterceptor(FlipperOkhttpInterceptor(flipperPlugin))
        .addNetworkInterceptor {chain->
            val original = chain.request()

            val originalAuthToken = original.header("Authorization")
            if (originalAuthToken.isNullOrEmpty()) {
                val requestBuilder = original.newBuilder()
                    .header(
                        "Authorization",
                        "Bearer ${BuildConfig.apiKey}"
                    ).header(
                        "App-Version",
                        BuildConfig.VERSION_NAME
                    )
                val request = requestBuilder.build()

                chain.proceed(request)
            } else {
                chain.proceed(original)
            }
        }
        .build()

    @Provides
    fun networkFlipperPlugin():NetworkFlipperPlugin = flipperPlugin

    @Provides
    fun retrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(General.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    @Provides
    fun provideTrendingApi(retrofit:Retrofit):TrendingApi =retrofit.create(TrendingApi::class.java)

    @Provides
    fun provideSearchApi(retrofit:Retrofit):SearchApi =retrofit.create(SearchApi::class.java)

    @Provides
    fun provideMovieApi(retrofit:Retrofit):MovieApi =retrofit.create(MovieApi::class.java)
}