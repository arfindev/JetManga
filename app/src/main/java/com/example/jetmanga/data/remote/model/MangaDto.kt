package com.example.jetmanga.data.remote.model

import com.example.jetmanga.domain.model.Manga

data class MangaDto(
    val altTitles: List<String>,
    val headerForImage: HeaderForImage,
    val id: String,
    val image: String,
    val title: String
)

fun MangaDto.toManga(): Manga {
    return Manga(
        id = id,
        image = image,
        title = title
    )
}