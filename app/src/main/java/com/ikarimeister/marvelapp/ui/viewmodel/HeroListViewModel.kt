package com.ikarimeister.marvelapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ikarimeister.marvelapp.domain.GetAllHeroes
import com.ikarimeister.marvelapp.domain.model.Hero
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HeroListViewModel @Inject constructor(
    private val getAllHeroes: GetAllHeroes,
    private val bgDispatcher: CoroutineDispatcher,
) : ViewModel() {

    val state = MutableLiveData<State>()

    fun start() = viewModelScope.launch {
        state.postValue(Loading)
        val newState = withContext(bgDispatcher) {
            getAllHeroes().takeUnless { it.isEmpty() }?.let { Content(it) } ?: Error
        }
        state.postValue(newState)
    }

    sealed class State
    object Loading : State()
    object Error : State()
    data class Content(val heroes: List<Hero>) : State()

}