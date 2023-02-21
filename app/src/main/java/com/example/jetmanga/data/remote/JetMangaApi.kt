package com.example.jetmanga.data.remote

import com.example.jetmanga.data.remote.model.MangaDetail
import com.example.jetmanga.data.remote.model.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface JetMangaApi {

    @GET("manga/mangasee123/demon")
    suspend fun getMostPopularManga(): Response

    @GET("manga/mangasee123/naruto")
    suspend fun getRecentReleaseManga(): Response

    @GET("manga/mangasee123/info")
    suspend fun getMangaDetails(
        @Query("id") id: String
    ): MangaDetail

}