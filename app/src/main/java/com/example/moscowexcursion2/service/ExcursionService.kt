package com.example.moscowexcursion2.service

import com.example.moscowexcursion2.di.DaggerExcursionApiComponent

class ExcursionService {

    lateinit var retrofit: ExcursionAPI

    init {
        DaggerExcursionApiComponent.create().injectService(this)
    }

    fun getExcursion() = retrofit.getExcursion()


}