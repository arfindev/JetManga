package com.example.jetmanga.presentation.Home_Screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetmanga.domain.repository.MangaRepository
import com.example.jetmanga.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val mangaRepository: MangaRepository
) : ViewModel() {

    private val _mostPopularMangaState = mutableStateOf(MostPopularDataState())
    val mostPopularMangaState: State<MostPopularDataState> = _mostPopularMangaState

    private val _recentReleaseMangaState = mutableStateOf(RecentReleaseMangaState())
    val recentReleaseMangaState: State<RecentReleaseMangaState> = _recentReleaseMangaState


    init {
        getMostPopularManga()
        getRecentReleaseManga()
    }

    private fun getMostPopularManga() {
        mangaRepository.getMostPopularManga().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _mostPopularMangaState.value =
                        MostPopularDataState(mostPopularManga = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _mostPopularMangaState.value = MostPopularDataState(
                        error = result.message ?: " An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _mostPopularMangaState.value = MostPopularDataState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }


    private fun getRecentReleaseManga() {
        mangaRepository.getRecentReleaseManga().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _recentReleaseMangaState.value =
                        RecentReleaseMangaState(recentReleaseManga = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _recentReleaseMangaState.value = RecentReleaseMangaState(
                        error = result.message ?: " An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _recentReleaseMangaState.value = RecentReleaseMangaState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}