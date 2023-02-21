package com.example.jetmanga.presentation.detail_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetmanga.domain.repository.MangaRepository
import com.example.jetmanga.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MangaDetailViewModel @Inject constructor(
    private val repository: MangaRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _mangaDetailState = mutableStateOf(MangaDetailState())
    val mangaDetailState: State<MangaDetailState> = _mangaDetailState


    init {
        savedStateHandle.get<String>("id")?.let { id ->
            getMangaById(id)
        }
    }


    private fun getMangaById(id: String) {
        viewModelScope.launch {
            repository.getMangaById(id).collect { result ->
                when (result) {
                    is Resource.Success -> {
                        _mangaDetailState.value = MangaDetailState(mangaDetail = result.data)
                    }
                    is Resource.Loading -> {
                        _mangaDetailState.value = MangaDetailState(isLoading = true)
                    }
                    is Resource.Error -> {
                        _mangaDetailState.value = MangaDetailState(
                            error = result.message ?: "An unexpected error occurred"
                        )

                    }
                }

            }
        }
    }


}