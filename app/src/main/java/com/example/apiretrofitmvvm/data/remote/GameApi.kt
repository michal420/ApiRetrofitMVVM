package com.example.apiretrofitmvvm.data.remote

import com.example.apiretrofitmvvm.data.remote.models.GameModel
import com.example.apiretrofitmvvm.data.remote.models.SpecificGameModel
import com.example.apiretrofitmvvm.util.Constants.Companion.GAMES_ENDPOINT
import com.example.apiretrofitmvvm.util.Constants.Companion.GAME_ID_ENDPOINT
import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GameApi {
    @GET(GAMES_ENDPOINT)
    suspend fun getGames(): retrofit2.Response<List<GameModel>>

    @GET(GAME_ID_ENDPOINT)
    suspend fun getGameById(@Query(value = "id") id: Int): retrofit2.Response<SpecificGameModel>
}