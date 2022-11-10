package com.example.viewmodelapi.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
//import com.example.networkcall.Model.Entry
import com.example.viewmodelapi.model.second_api_model.Entry

@Dao
interface EntryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(entry: List<Entry>)

    @Query("SELECT * FROM entrytable")
    fun fetchAllData(): LiveData<List<Entry>>

    @Query("DELETE FROM entrytable")
    fun emptyTable()
}