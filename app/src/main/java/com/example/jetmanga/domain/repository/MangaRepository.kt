package com.example.jetmanga.domain.repository

import com.example.jetmanga.data.remote.model.MangaDetail
import com.example.jetmanga.data.remote.model.MangaDto
import com.example.jetmanga.domain.model.Manga
import com.example.jetmanga.util.Resource
import kotlinx.coroutines.flow.Flow

interface MangaRepository {

    fun getMostPopularManga(): Flow<Resource<List<MangaDto>>>

    fun getRecentReleaseManga(): Flow<Resource<List<MangaDto>>>

    fun getMangaById(id: String): Flow<Resource<MangaDetail>>

}