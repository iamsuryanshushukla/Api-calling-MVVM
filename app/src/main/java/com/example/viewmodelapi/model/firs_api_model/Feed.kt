package com.example.viewmodelapi.model.firs_api_model

data class Feed(
    val author: Author,
    val copyright: String,
    val country: String,
    val icon: String,
    val id: String,
    val links: List<Link>,
    val results: ArrayList<Result>,
    val title: String,
    val updated: String
)