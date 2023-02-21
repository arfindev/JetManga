package com.example.jetmanga.presentation.navigation

sealed class Screen(val route: String) {
    object MangaListScreen : Screen("manga_list_screen")
    object MangaDetailScreen : Screen("manga_detail_screen/{id}") {
        fun passMangaId(id: String): String {
            return "manga_detail_screen/$id"
        }
    }
}