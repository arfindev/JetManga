package com.example.jetmanga.data.remote.repository

import com.example.jetmanga.data.remote.JetMangaApi
import com.example.jetmanga.data.remote.model.MangaDetail
import com.example.jetmanga.data.remote.model.MangaDto
import com.example.jetmanga.data.remote.model.toManga
import com.example.jetmanga.domain.model.Manga
import com.example.jetmanga.domain.repository.MangaRepository
import com.example.jetmanga.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class MangaRepositoryImpl @Inject constructor(
    private val mangaApi: JetMangaApi
) : MangaRepository {

    override fun getMostPopularManga(): Flow<Resource<List<MangaDto>>> = flow {
        try {
            emit(Resource.Loading())
            val response = mangaApi.getMostPopularManga()
            emit(Resource.Success(response.results))

        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }
    }

    override fun getRecentReleaseManga(): Flow<Resource<List<MangaDto>>> = flow {
        try {
            emit(Resource.Loading())
            val response = mangaApi.getRecentReleaseManga()
            emit(Resource.Success(response.results))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }
    }


    override fun getMangaById(id: String): Flow<Resource<MangaDetail>> = flow {
        try {
            emit(Resource.Loading())
            val response = mangaApi.getMangaDetails(id)
            emit(Resource.Success(response))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }
    }
}