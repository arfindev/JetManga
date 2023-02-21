package com.example.jetmanga.presentation.Home_Screen

import com.example.jetmanga.data.remote.model.MangaDto

data class RecentReleaseMangaState(
    val isLoading: Boolean = false,
    val recentReleaseManga: List<MangaDto> = emptyList(),
    val error: String = ""
)
