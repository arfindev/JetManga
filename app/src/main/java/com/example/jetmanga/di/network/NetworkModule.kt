package com.example.jetmanga.di.network

import com.example.jetmanga.data.remote.JetMangaApi
import com.example.jetmanga.data.remote.repository.MangaRepositoryImpl
import com.example.jetmanga.domain.repository.MangaRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideJetMangaApiService(): JetMangaApi {
        return Retrofit.Builder().baseUrl("https://api.consumet.org/").addConverterFactory(
            GsonConverterFactory.create()
        ).build()
            .create(JetMangaApi::class.java)
    }


    @Provides
    @Singleton
    fun providesMangaRepository(mangaApi: JetMangaApi): MangaRepository {
        return MangaRepositoryImpl(mangaApi)
    }

}