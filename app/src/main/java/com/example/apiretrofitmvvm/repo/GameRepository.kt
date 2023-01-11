package com.example.apiretrofitmvvm.repo

import com.example.apiretrofitmvvm.data.remote.GameService
import com.example.apiretrofitmvvm.domain.items.GameItem
import com.example.apiretrofitmvvm.domain.items.SpecificGameItem
import com.example.apiretrofitmvvm.domain.items.toGameItem
import com.example.apiretrofitmvvm.domain.items.toSpecificGameItem
import javax.inject.Inject

class GameRepository @Inject constructor(private val gameService: GameService) {
    suspend fun getGames(): List<GameItem> {
        return gameService.getGames().map {
            it.toGameItem()
        }
    }

    suspend fun getGameById(id: Int): SpecificGameItem {
        return gameService.getGameById(id).toSpecificGameItem()
    }

}