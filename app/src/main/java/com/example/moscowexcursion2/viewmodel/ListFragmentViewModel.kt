package com.example.moscowexcursion2.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.moscowexcursion2.di.DaggerViewModelComponent
import com.example.moscowexcursion2.model.Data
import com.example.moscowexcursion2.model.InfoExcursion
import com.example.moscowexcursion2.service.ExcursionService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers


import javax.inject.Inject


class ListFragmentViewModel(application: Application) : AndroidViewModel(application) {
    val excursion by lazy { MutableLiveData<List<Data>>() }
    val loadError by lazy { MutableLiveData<Boolean>() }
    val loading by lazy { MutableLiveData<Boolean>() }
    private lateinit var myApplication: Application

    @Inject
    lateinit var retrofit: ExcursionService

    private val disposable = CompositeDisposable()

    init {
        DaggerViewModelComponent.create().inject(this)

    }

    fun refresh() {
        loading.value = true
        myApplication = getApplication()
        getExs()
    }

    fun getExs() {
        disposable.add(
            retrofit.getExcursion()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<InfoExcursion>() {
                    override fun onSuccess(t: InfoExcursion) {
                        loadError.value = false
                        loading.value = false
                       excursion.value = t.data
                    }

                    override fun onError(e: Throwable) {
                        loadError.value = true
                        loading.value = false
                        excursion.value = null
                    }

                })
        )



    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }



}
