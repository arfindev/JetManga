package com.example.jetmanga.presentation.detail_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage

@Composable
fun MangaDetailScreen(
    mangaDetailViewModel: MangaDetailViewModel = hiltViewModel()
) {

    val state = mangaDetailViewModel.mangaDetailState.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        state.mangaDetail.let { manga ->
            AsyncImage(model = manga?.image, contentDescription = "manga")
        }

    }

}