package com.example.apiretrofitmvvm.ui.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apiretrofitmvvm.domain.GetGameByIdUseCase
import com.example.apiretrofitmvvm.domain.GetGamesUseCase
import com.example.apiretrofitmvvm.domain.items.GameItem
import com.example.apiretrofitmvvm.domain.items.SpecificGameItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val getGamesUseCase: GetGamesUseCase,
    private val getGameByIdUseCase: GetGameByIdUseCase
) : ViewModel() {

    private val _games = MutableLiveData<List<GameItem>>()
    val games: LiveData<List<GameItem>> get() = _games

    private val _game = MutableLiveData<SpecificGameItem>()
    val game: LiveData<SpecificGameItem> get() = _game

    init {
        getGames()
    }

    private fun getGames() {
        viewModelScope.launch {
            try {
                val games = getGamesUseCase()
                _games.value = games
            } catch (_: Exception) {
            }
        }
    }

    fun getGameById(id: Int) {
        viewModelScope.launch {
            try {
                val game = getGameByIdUseCase(id)
                _game.value = game
            } catch (_: Exception) {
            }
        }
    }
}