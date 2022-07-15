package com.example.moscowexcursion2.api

import com.example.moscowexcursion2.model.InfoExcursion
import retrofit2.Response
import retrofit2.http.GET

interface ExcursionService {

    @GET("v1.0")
    suspend fun getExcursion(): Response<InfoExcursion>
}