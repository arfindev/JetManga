package com.example.jetmanga.presentation.detail_screen

import com.example.jetmanga.data.remote.model.MangaDetail

data class MangaDetailState(
    val isLoading: Boolean = false,
    val mangaDetail: MangaDetail? = null,
    val error: String = ""
)
