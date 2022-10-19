package com.example.viewmodelapi.interfaces

//import com.example.apicalling.models.Feed
//import com.example.apicalling.models.Model
//import com.example.apicalling.models.Result
import com.example.viewmodelapi.model.Apps
//import com.example.jetpackapi.AppsInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {
    @GET("v2/in/apps/top-free/10/apps.json")
    suspend fun getData(): Apps
//    companion object{
//        var apiService: ApiInterface?=null
//        fun getInstace(): ApiInterface {
//            if (apiService == null){
////                apiService = Retrofit.Builder().baseUrl("https://rss.applemarketingtools.com/")
////                    .addConverterFactory(GsonConverterFactory.create()).build().create(AppsInterface::class.java)
//                apiService = Retrofit.Builder().baseUrl("https://rss.applemarketingtools.com/api/")
//                    .addConverterFactory(GsonConverterFactory.create()).build().create(ApiInterface::class.java)
//            }
//            return apiService!!
//        }
//
//    }
}