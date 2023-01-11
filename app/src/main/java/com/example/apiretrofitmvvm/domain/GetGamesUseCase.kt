package com.example.apiretrofitmvvm.domain

import com.example.apiretrofitmvvm.domain.items.GameItem
import com.example.apiretrofitmvvm.repo.GameRepository
import javax.inject.Inject

class GetGamesUseCase @Inject constructor(private val gameRepository: GameRepository) {
    suspend operator fun invoke(): List<GameItem> {
        return gameRepository.getGames().shuffled()
    }
}