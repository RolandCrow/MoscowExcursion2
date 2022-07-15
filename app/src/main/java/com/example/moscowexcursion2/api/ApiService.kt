package com.example.moscowexcursion2.api

import com.example.moscowexcursion2.model.InfoExcursion
import retrofit2.Response


interface ApiService {

    suspend fun getExcursionList(): Response<InfoExcursion>

}