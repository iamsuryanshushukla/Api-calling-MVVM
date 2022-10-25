package com.example.viewmodelapi.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.viewmodelapi.services.RetroInstacne
import com.example.viewmodelapi.interfaces.ApiInterface
import com.example.viewmodelapi.model.firs_api_model.Apps
import kotlinx.coroutines.launch

class MainViewModel : ViewModel(){
    lateinit var recyclerListLiveData:MutableLiveData<Apps>

    init {
        recyclerListLiveData = MutableLiveData()
    }

    fun getRecyclereListObserver():MutableLiveData<Apps>{
        return recyclerListLiveData
    }

    fun makeApiCall(){
        viewModelScope.launch {
            val retroInstance = RetroInstacne.getRetroInstance2()
                .create(ApiInterface::class.java)
            val response = retroInstance.getData()
            recyclerListLiveData.postValue(response)
        }
    }

}