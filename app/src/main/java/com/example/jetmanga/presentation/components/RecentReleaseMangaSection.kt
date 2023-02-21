package com.example.jetmanga.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.jetmanga.data.remote.model.HeaderForImage
import com.example.jetmanga.data.remote.model.MangaDto
import com.example.jetmanga.presentation.Home_Screen.HomeScreenViewModel
import com.example.jetmanga.presentation.navigation.Screen
import com.example.jetmanga.util.FontOswald
import com.example.jetmanga.util.FontPoppins

@Composable
fun RecentReleaseSection(
    viewModel: HomeScreenViewModel = hiltViewModel(),
    navHostController: NavController
) {

    val recentReleaseState = viewModel.recentReleaseMangaState.value
    LazyRow {
        items(recentReleaseState.recentReleaseManga) { manga ->
            RecentReleaseMangaItem(manga = manga, navHostController = navHostController)
        }
    }
}


@Composable
fun RecentReleaseMangaShimmerItem(
) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(10) {
            Box(
                modifier = Modifier
                    .height(220.dp)
                    .width(160.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .shimmerEffect(),
            )
        }
    }
}

@Composable
fun RecentReleaseMangaItem(manga: MangaDto, navHostController: NavController) {

    Column(modifier = Modifier.fillMaxSize()) {
        Card(
            modifier = Modifier
                .height(220.dp)
                .width(160.dp)
                .padding(start = 0.dp, end = 8.dp, top = 8.dp, bottom = 8.dp)
                .clickable {
                    navHostController.navigate(Screen.MangaDetailScreen.passMangaId(id = manga.id))
                },
            shape = RoundedCornerShape(30.dp)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                AsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    model = manga.image,
                    contentDescription = "My Image",
                    contentScale = ContentScale.Crop
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp, top = 0.dp)
        ) {
            Text(
                text = manga.title.take(17),
                style =
                TextStyle(
                    fontFamily = FontPoppins,
                    color = Color.Black, fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                ),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )

        }

    }
}


//@Preview
//@Composable
//fun RecentMangaReleaseItem() {
//    RecentReleaseMangaItem(
//        manga = MangaDto(
//            altTitles = emptyList(),
//            headerForImage = HeaderForImage(""),
//            id = "",
//            image = "",
//            title = "this is a titleegsgsgsags"
//        )
//    )
//
//}

@Preview
@Composable
fun PreviewRecentReleaseMangaShimmerItem() {

    RecentReleaseMangaShimmerItem()
}