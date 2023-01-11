package com.example.apiretrofitmvvm.data.remote.models

data class GameModel(
    val id: Int,
    val title: String,
    val thumbnail: String,
    val short_description: String,
    val genre: String,
    val platform: String
)
