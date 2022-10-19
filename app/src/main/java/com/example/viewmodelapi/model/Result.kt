package com.example.viewmodelapi.model

data class Result(
    val artistName: String,
    val artworkUrl100: String,
    val genres: List<Any>,
    val id: String,
    val kind: String,
    val name: String,
    val releaseDate: String,
    val url: String
)