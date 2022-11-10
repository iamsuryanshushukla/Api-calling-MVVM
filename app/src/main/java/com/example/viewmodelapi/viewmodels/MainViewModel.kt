package com.example.viewmodelapi.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.viewmodelapi.Database.EntryDataBase
import com.example.viewmodelapi.adapters.ItemRecyclerAdapter
import com.example.viewmodelapi.services.RetroInstacne
import com.example.viewmodelapi.interfaces.ApiInterface
import com.example.viewmodelapi.model.firs_api_model.Apps
import kotlinx.coroutines.launch

class MainViewModel : ViewModel(){
    var recyclerListLiveData: MutableLiveData<Apps>
    private val datasave = EntryDataBase.INSTANCE?.entryDao()

    val itemAppsAdapter:ItemRecyclerAdapter = ItemRecyclerAdapter()

    fun getAppsAdapter():ItemRecyclerAdapter{
        return itemAppsAdapter
    }

    fun setAdapterData(data: ArrayList<com.example.viewmodelapi.model.firs_api_model.Result>) {
        itemAppsAdapter.setUpdateData(data)
        itemAppsAdapter.notifyDataSetChanged()
    }

    init {
        recyclerListLiveData = MutableLiveData()
        makeApiCallentry()
    }

    fun getRecyclereListObserver(): MutableLiveData<Apps> {
        return recyclerListLiveData
    }

    fun makeApiCall(){
        viewModelScope.launch {
            val retroInstance = RetroInstacne.getRetroInstance("https://rss.applemarketingtools.com/api/").create(ApiInterface::class.java)
            try {
                val response = retroInstance.getData()
                recyclerListLiveData.postValue(response)
            }catch (e : Exception){

            }

        }
    }


    fun makeApiCallentry(){
        viewModelScope.launch{
            val retroInstance = RetroInstacne.getRetroInstance("https://api.publicapis.org/").create(ApiInterface::class.java)
            try {
                val response = retroInstance.getDatafromApi()
                datasave?.emptyTable()
                datasave?.insertData(response.entries.subList(0,150))
            }catch (e : Exception){
                Log.i("",e.toString())
            }

        }
    }


}