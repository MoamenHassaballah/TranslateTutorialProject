package com.moaapps.translate.ui.views

import android.util.Log
import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moaapps.translate.R
import com.moaapps.translate.ui.theme.TranslateTheme
import com.moaapps.translate.ui.theme.blue
import com.moaapps.translate.ui.theme.darkBlue
import com.moaapps.translate.ui.theme.lightGray

//
// Created by MoaApps on 12/08/2024.
//


@Composable
fun MainView(selectedItem: Int, onOpenDrawer: () -> Unit = {}) {

    var title by remember {
        mutableStateOf("Translate")
    }

    var icon by remember {
        mutableIntStateOf(R.drawable.ic_t_letter)
    }

    LaunchedEffect(key1 = selectedItem) {
        when (selectedItem){
            0 -> {
                title = "Translate"
                icon = R.drawable.ic_t_letter
            }
            1 -> {
                title = "Favourites"
                icon = R.drawable.ic_star
            }
            2 -> {
                title = "History"
                icon = R.drawable.ic_history

            }
        }
    }

    Column {
        TopBar(
            title = title,
            icon = icon
        ) {
            onOpenDrawer()
        }

        when (selectedItem){
            0 -> {
                TranslationView()
            }
            1 -> {
                FavoritesPageView()
            }
            2 -> {
                HistoryPageView()
            }
        }

    }
}

@Composable
fun TopBar(title: String, icon: Int, onOpenDrawer: () -> Unit = {}){

    val devicePaddingValues = WindowInsets.systemBars.asPaddingValues()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(lightGray)
            .height(100.dp + devicePaddingValues.calculateTopPadding())


    ){
        Row (
            Modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight()
                .background(
                    blue,
                    shape = RoundedCornerShape(
                        bottomEnd = 50.dp
                    )
                )
                .padding(top = devicePaddingValues.calculateTopPadding()),
            verticalAlignment = Alignment.CenterVertically
        ){

            Button(
                onClick = {  },
                colors = ButtonDefaults.buttonColors().copy(
                    containerColor = Color.Transparent,
                    contentColor = Color.White
                ),

                ) {

                Icon(
                    painter = painterResource(id = R.drawable.ic_menu),
                    contentDescription = "drawer menu",
                    Modifier
                        .size(30.dp)
                        .clickable {
                            onOpenDrawer()
                        }
                )

            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = title,
                color = Color.White,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .padding(end = 40.dp)
            )

        }

        Box (
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .fillMaxHeight()
                .padding(top = devicePaddingValues.calculateTopPadding())
        ){

            Icon(
                painter = painterResource(id = icon),
                contentDescription = "app icon",
                modifier = Modifier
                    .size(50.dp)
                    .shadow(10.dp)
                    .background(
                        Color.White,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(10.dp)
                    .align(Alignment.CenterEnd)
            )

        }
    }



}

@Preview(showSystemUi = true)
@Composable
fun MainViewPreview(){
    TranslateTheme {
        MainView(0)
    }
}

