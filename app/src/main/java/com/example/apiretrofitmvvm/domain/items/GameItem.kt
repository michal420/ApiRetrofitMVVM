package com.example.apiretrofitmvvm.domain.items

import com.example.apiretrofitmvvm.data.remote.models.GameModel

data class GameItem(
    val id: Int,
    val title: String,
    val thumbnail: String,
    val short_description: String,
    val genre: String,
    val platform: String
)

fun GameModel.toGameItem() = GameItem(id, title, thumbnail, short_description, genre, platform)
