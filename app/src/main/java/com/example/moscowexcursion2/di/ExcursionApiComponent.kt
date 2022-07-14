package com.example.moscowexcursion2.di

import com.example.moscowexcursion2.service.ExcursionService
import dagger.Component


@Component(modules = [ExcursionApiModule::class])
interface ExcursionApiComponent {


    fun injectService(service: ExcursionService)

}