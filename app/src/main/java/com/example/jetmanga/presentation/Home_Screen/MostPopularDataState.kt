package com.example.jetmanga.presentation.Home_Screen

import com.example.jetmanga.data.remote.model.MangaDto
import com.example.jetmanga.domain.model.Manga

data class MostPopularDataState(
    val isLoading: Boolean = false,
    val mostPopularManga: List<MangaDto> = emptyList(),
    val error: String = ""

)
