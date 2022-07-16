package com.example.moscowexcursion2.repository

import com.example.moscowexcursion2.api.ApiService
import com.example.moscowexcursion2.api.ExcursionService
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class MainRepository   @Inject constructor(private val  apiService: ExcursionService) {

    suspend fun getExcursionList() = apiService.getExcursion()
}