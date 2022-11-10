package com.example.viewmodelapi.model.second_api_model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "entrytable")
data class Entry(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val API: String,
    val Auth: String,
    val Category: String,
    val Cors: String,
    val Description: String,
    val HTTPS: Boolean,
    val Link: String
)