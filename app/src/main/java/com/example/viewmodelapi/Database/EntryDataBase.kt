package com.example.viewmodelapi.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.viewmodelapi.model.second_api_model.Entry


@Database(entities = [Entry::class], version = 3, exportSchema = false)
abstract class EntryDataBase : RoomDatabase() {

    abstract fun entryDao() : EntryDao

    companion object {
        var INSTANCE: EntryDataBase? = null

        fun getDatabase(context: Context): EntryDataBase {
            if (INSTANCE ==null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext,
                    EntryDataBase::class.java, "jetpack")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }

            return INSTANCE!!
        }
    }

}