package com.example.jetmanga.presentation.Home_Screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.jetmanga.presentation.components.*
import com.example.jetmanga.util.FontOswald

@Composable
fun HomeScreen(viewModel: HomeScreenViewModel = hiltViewModel(), navHostController: NavController) {

    val mostPopularState = viewModel.mostPopularMangaState.value

    val recentReleaseState = viewModel.recentReleaseMangaState.value

    var bottomState by remember {
        mutableStateOf("Home")
    }

    Scaffold(
        topBar = {
            TopBar()
        },
        bottomBar = {
            BottomNavigation(
                modifier = Modifier.clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))

            ) {
                BottomNavigationItem(
                    selected = bottomState == "Home",
                    onClick = { bottomState = "Home" },
                    label = { Text(text = "Home") },
                    icon = { Icon(imageVector = Icons.Default.Home, contentDescription = null) }
                )

                BottomNavigationItem(
                    selected = bottomState == "Home",
                    onClick = { bottomState = "Home" },
                    label = { Text(text = "Home") },
                    icon = { Icon(imageVector = Icons.Default.Search, contentDescription = null) }
                )

                BottomNavigationItem(
                    selected = bottomState == "Home",
                    onClick = { bottomState = "Home" },
                    label = { Text(text = "Home") },
                    icon = { Icon(imageVector = Icons.Default.Share, contentDescription = null) }
                )
            }
        }, content = { paddingValues ->

            Surface(modifier = Modifier.padding(15.dp)) {
                Column {
                    Text(
                        text = "Most Popular", style = TextStyle(
                            fontFamily = FontOswald,
                            color = Color.Black, fontSize = 24.sp,
                        )
                    )
                    if (mostPopularState.isLoading) {
                        MostPopularMangaShimmerItem()
                    } else {
                        MostPopularMangaSection()
                    }

                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Recent Release", style = TextStyle(
                            fontFamily = FontOswald,
                            color = Color.Black, fontSize = 24.sp,
                        )
                    )
                    if (recentReleaseState.isLoading) {
                        RecentReleaseMangaShimmerItem()
                    } else {
                        RecentReleaseSection(navHostController = navHostController)
                    }
                }
            }
        }
    )
}