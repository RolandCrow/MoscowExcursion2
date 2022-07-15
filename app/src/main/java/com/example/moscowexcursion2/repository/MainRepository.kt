package com.example.moscowexcursion2.repository

import com.example.moscowexcursion2.api.ApiService

class MainRepository(private val  apiService: ApiService) {

    suspend fun getExcursionList() = apiService.getExcursionList()
}