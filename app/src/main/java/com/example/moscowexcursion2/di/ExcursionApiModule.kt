package com.example.moscowexcursion2.di

import com.example.moscowexcursion2.service.ExcursionAPI
import com.example.moscowexcursion2.service.ExcursionService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


@Module
class ExcursionApiModule {

    private val BASE_URL = "https://devapp.mosmetro.ru/api/excursions/"


    @Provides
    fun providesExcursionAPI(): ExcursionAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(ExcursionAPI::class.java)




    }

    @Provides
    fun provideService(): ExcursionService {
        return ExcursionService()
    }



}