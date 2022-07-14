package com.example.moscowexcursion2.di

import com.example.moscowexcursion2.viewmodel.ListFragmentViewModel
import dagger.Component

@Component(modules = [ExcursionApiModule::class])
interface ViewModelComponent {

    fun inject(viewModel: ListFragmentViewModel)
}