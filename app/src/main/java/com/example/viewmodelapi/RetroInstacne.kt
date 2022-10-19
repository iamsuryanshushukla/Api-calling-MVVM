package com.example.viewmodelapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstacne {
    companion object {

        val BASE_URL = "https://rss.applemarketingtools.com/api/"

        fun getRetroInstance(): Retrofit {

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}