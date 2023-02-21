package com.example.jetmanga.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetmanga.R
import com.example.jetmanga.ui.theme.PinkRed
import com.example.jetmanga.util.FontPoppins

@Composable
fun TopBar() {
    TopAppBar(
        elevation = 0.dp,
        modifier = Modifier.padding(start = 10.dp, end = 10.dp),

        title = {
            Column {
                Text(
                    text = "Hi, Good Morning",
                    textAlign = TextAlign.Start,
                    fontFamily = FontPoppins,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
                Text(
                    text = "Arfin Hosain",
                    textAlign = TextAlign.Start,
                    fontFamily = FontPoppins,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    style = TextStyle(color = PinkRed)
                )
            }
        },
        navigationIcon = {
            Image(painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "profile image",
                modifier = Modifier
                    .size(58.dp)
                    .clip(
                        CircleShape
                    )
                    .clickable {

                    })
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.search),
                    contentDescription = null, tint = Color.White
                )

            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.bell),
                    contentDescription = null, tint = Color.White
                )

            }
        }
    )
}


@Preview
@Composable
fun PreviewTopBar() {
    TopBar()
}