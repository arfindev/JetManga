package com.example.jetmanga.data.remote.model

import com.example.jetmanga.domain.model.Manga

data class Response(
    val results: List<MangaDto>
)
