package com.example.viewmodelapi.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstacne {
    companion object {

//        val BASE_URL = "https://rss.applemarketingtools.com/api/"

        fun getRetroInstance(): Retrofit {

            return Retrofit.Builder()
                .baseUrl("https://api.publicapis.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        fun getRetroInstance2(): Retrofit {

            return Retrofit.Builder()
                .baseUrl("https://rss.applemarketingtools.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
//        fun getRetroInstance2(): Retrofit {
//
//            return Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//        }
    }
}