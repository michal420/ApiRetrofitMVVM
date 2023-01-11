package com.example.apiretrofitmvvm.domain

import com.example.apiretrofitmvvm.domain.items.SpecificGameItem
import com.example.apiretrofitmvvm.repo.GameRepository
import javax.inject.Inject

class GetGameByIdUseCase @Inject constructor(private val gameRepository: GameRepository) {
    suspend operator fun invoke(id: Int): SpecificGameItem {
        return gameRepository.getGameById(id)
    }
}