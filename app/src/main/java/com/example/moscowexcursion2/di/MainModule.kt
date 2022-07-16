package com.example.moscowexcursion2.di




import com.example.moscowexcursion2.api.ApiService
import com.example.moscowexcursion2.api.ExcursionService
import com.example.moscowexcursion2.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideBaseUrl() = Constants.BASE_URL




    @Singleton
    @Provides
     fun provideRetrofit(BASE_URL: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
     fun provideExcursionService(retrofit: Retrofit): ExcursionService =
        retrofit.create(ExcursionService::class.java)

    /* @Provides
    @Singleton
    fun provideApiService(apiService: ApiService): ApiService = apiService */




}