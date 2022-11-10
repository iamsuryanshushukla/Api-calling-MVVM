package com.example.viewmodelapi.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.viewmodelapi.model.second_api_model.Entry
import com.example.viewmodelapi.Database.EntryDataBase
import com.example.viewmodelapi.adapters.RecyclerViewAdapter

class MainActivityViewModel:ViewModel() {



    lateinit var recyclerListLiveData: LiveData<List<Entry>>
    private val datasave = EntryDataBase.INSTANCE?.entryDao()
    val entriesAdapter = RecyclerViewAdapter()


    fun getEntries():RecyclerViewAdapter{
        return entriesAdapter
    }

    fun setEntriesAdapter(entry: List<Entry>){
        entriesAdapter.setUpdateData(entry)
        entriesAdapter.notifyDataSetChanged()
    }

    init {
        recyclerListLiveData = datasave?.fetchAllData()!!
    }

    fun getRecyclereListObserver(): LiveData<List<Entry>> {
        return recyclerListLiveData
    }





}