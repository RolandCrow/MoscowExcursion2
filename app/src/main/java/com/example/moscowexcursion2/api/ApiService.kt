package com.example.moscowexcursion2.api

import com.example.moscowexcursion2.model.InfoExcursion
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Response
import javax.inject.Singleton


interface ApiService {


    suspend fun getExcursionList(): Response<InfoExcursion>

}