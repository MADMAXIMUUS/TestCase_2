package ru.madmax.autodoctestcase.di

import android.app.Application
import coil.ImageLoader
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.madmax.autodoctestcase.data.remote.GitHubApi
import ru.madmax.autodoctestcase.data.repository.GitHubRepositoryImpl
import ru.madmax.autodoctestcase.domain.repository.GitHubRepository
import ru.madmax.autodoctestcase.domain.use_case.GetRepositoriesUseCase
import ru.madmax.autodoctestcase.domain.use_case.GetUserUseCase
import ru.madmax.autodoctestcase.domain.use_case.GitHubUseCases
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor {
                val token = ""
                val modifiedRequest = it.request().newBuilder()
                    .addHeader("Authorization", "token $token")
                    .build()
                it.proceed(modifiedRequest)
            }
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideImageLoader(app: Application): ImageLoader {
        return ImageLoader.Builder(app)
            .crossfade(true)
            .build()
    }

    @Provides
    @Singleton
    fun provideGitGubApi(client: OkHttpClient): GitHubApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(GitHubApi.BASE_URL)
            .client(client)
            .build()
            .create(GitHubApi::class.java)
    }

    @Provides
    @Singleton
    fun provideGitHubRepository(gitHubApi: GitHubApi): GitHubRepository {
        return GitHubRepositoryImpl(gitHubApi)
    }

    @Provides
    @Singleton
    fun provideGitHubUseCases(gitHubRepository: GitHubRepository): GitHubUseCases {
        return GitHubUseCases(
            GetRepositoriesUseCase(gitHubRepository),
            GetUserUseCase(gitHubRepository)
        )
    }
}