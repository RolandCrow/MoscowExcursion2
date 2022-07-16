package com.example.moscowexcursion2.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moscowexcursion2.model.InfoExcursion
import com.example.moscowexcursion2.repository.MainRepository
import com.example.moscowexcursion2.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: MainRepository): ViewModel() {

    private val  _excursionItem = MutableLiveData<Resource<InfoExcursion>>()
    val excursionItem: LiveData<Resource<InfoExcursion>>
            get() = _excursionItem

    init {
        getInfoExcursion()
    }

    private fun getInfoExcursion() {
        viewModelScope.launch {
            _excursionItem.postValue(Resource.loading(null))
            mainRepository.getExcursionList().let {
                _excursionItem.postValue(Resource.success(it.body()))
            }
        }
    }

}