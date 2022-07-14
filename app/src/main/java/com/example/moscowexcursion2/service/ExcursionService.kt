package com.example.moscowexcursion2.service

import com.example.moscowexcursion2.di.DaggerExcursionApiComponent
import javax.inject.Inject

class ExcursionService {

    @Inject
    lateinit var retrofit: ExcursionAPI

    init {
        DaggerExcursionApiComponent.create().injectService(this)
    }

    fun getExcursion() = retrofit.getExcursion()


}