package com.example.viewmodelapi.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newapi.ApiModel
import com.example.viewmodelapi.interfaces.ApiInterface
import com.example.viewmodelapi.model.firs_api_model.Apps
import com.example.viewmodelapi.services.RetroInstacne
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO

class MainActivityViewModel:ViewModel() {


    lateinit var recyclerListLiveData:MutableLiveData<ApiModel>
    lateinit var recyclerListLive2Data:MutableLiveData<Apps>

    init {
        recyclerListLiveData = MutableLiveData()
        recyclerListLive2Data = MutableLiveData()
    }


//    lateinit var recyclerListLive2Data:MutableLiveData<Apps>

//    init {
//        recyclerListLive2Data = MutableLiveData()
//    }

    fun getRecyclereList2Observer():MutableLiveData<Apps>{
        return recyclerListLive2Data
    }


    fun getRecyclereListObserver():MutableLiveData<ApiModel>{
        return recyclerListLiveData
    }

    fun makeApiCall(){
        CoroutineScope(IO).launch {
            val retroInstance = RetroInstacne.getRetroInstance().create(ApiInterface::class.java)
            val retroInstance2 = RetroInstacne.getRetroInstance2()
                .create(ApiInterface::class.java)
//            val response =

            val response =
//                async {
                retroInstance.getDatafromApi()

//            }

//            val getResponse1  = response.await()
            recyclerListLiveData.postValue(response)

            val response2 =
                async {
                retroInstance2.getData()
            }


            val getResponse2 = response2.await()
            recyclerListLive2Data.postValue(getResponse2)

        }
    }




}