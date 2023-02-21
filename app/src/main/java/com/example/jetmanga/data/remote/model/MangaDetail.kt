package com.example.jetmanga.data.remote.model

data class MangaDetail(
    val altTitles: List<String>,
    val chapters: List<Chapter>,
    val description: String,
    val genres: List<String>,
    val headerForImage: HeaderForImageX,
    val id: String,
    val image: String,
    val title: String
)