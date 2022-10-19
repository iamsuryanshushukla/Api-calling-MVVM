package com.example.viewmodelapi

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.viewmodelapi.interfaces.ApiInterface
import com.example.viewmodelapi.model.Apps
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
            val retroInstance = RetroInstacne.getRetroInstance().create(ApiInterface::class.java)
            val response = retroInstance.getData()
            recyclerListLiveData.postValue(response)
        }
    }

}