package com.example.moscowexcursion2.di

import com.example.moscowexcursion2.api.ApiService
import com.example.moscowexcursion2.api.ApiServiceImpl
import com.example.moscowexcursion2.api.ExcursionService
import com.example.moscowexcursion2.repository.MainRepository
import com.example.moscowexcursion2.util.Constants
import com.example.moscowexcursion2.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



val mainModule = module {
        single {provideRetrofit(Constants.BASE_URL)}
        factory<ExcursionService> {provideExcursionService(get())}

    factory<ApiServiceImpl> {
        return@factory ApiServiceImpl(get())
    }



    single {
        MainRepository(apiService = get())
    }

  viewModel { MainViewModel(mainRepository = get()) }




    }

    private fun provideRetrofit(BASE_URL: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    private fun provideExcursionService(retrofit: Retrofit): ExcursionService = retrofit.create(ExcursionService::class.java)




