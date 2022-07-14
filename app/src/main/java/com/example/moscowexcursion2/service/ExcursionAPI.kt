package com.example.moscowexcursion2.service

import com.example.moscowexcursion2.model.InfoExcursion
import io.reactivex.Single

import retrofit2.http.GET

interface ExcursionAPI {

    @GET("v1.0")
    fun getExcursion(): Single<InfoExcursion>
}