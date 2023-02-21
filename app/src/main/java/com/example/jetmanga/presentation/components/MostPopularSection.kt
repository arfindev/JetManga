package com.example.jetmanga.presentation.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.jetmanga.data.remote.model.MangaDto
import com.example.jetmanga.presentation.Home_Screen.HomeScreenViewModel
import com.example.jetmanga.util.FontOswald

@Composable
fun MostPopularMangaSection(viewModel: HomeScreenViewModel = hiltViewModel()) {

    val mostPopularState = viewModel.mostPopularMangaState.value


    LazyRow(
        modifier = Modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(
            start = 0.dp,
            end = 24.dp
        )
    ) {
        items(mostPopularState.mostPopularManga) { manga ->
            MostPopularMangaItems(manga = manga)
        }
    }
}


@Composable
fun MostPopularMangaShimmerItem(
) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(10) {
            Box(
                modifier = Modifier
                    .height(180.dp)
                    .width(290.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .shimmerEffect(),
            )
        }
    }
}


@Composable
fun MostPopularMangaItems(manga: MangaDto) {

    Card(
        modifier = Modifier
            .height(180.dp)
            .width(290.dp), shape = RoundedCornerShape(30.dp)
    ) {
            Box {
                AsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    model = manga.image,
                    contentDescription = "My Image",
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = manga.title,
                    style =
                    TextStyle(
                        fontFamily = FontOswald,
                        color = Color.White, fontSize = 18.sp,

                        ),
                    maxLines = 1,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomStart)
                        .background(
                            Brush.verticalGradient(
                                0F to Color.Transparent,
                                .5F to Color.Black.copy(alpha = 0.3F),
                                1F to Color.Black.copy(alpha = 0.8F)
                            )
                        )
                        .padding(start = 20.dp, end = 8.dp, bottom = 30.dp, top = 24.dp),
                )
            }



    }
}