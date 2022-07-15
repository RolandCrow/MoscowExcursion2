package com.example.moscowexcursion2.api

import com.example.moscowexcursion2.model.InfoExcursion
import retrofit2.Response

class ApiServiceImpl(private val  apiService: ApiService): ApiService {
    override suspend fun getExcursionList(): Response<InfoExcursion> = apiService.getExcursionList()


}