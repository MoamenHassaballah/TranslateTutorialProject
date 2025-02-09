package com.moaapps.translate.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moaapps.translate.R
import com.moaapps.translate.models.DrawerItem
import com.moaapps.translate.ui.theme.TranslateTheme
import com.moaapps.translate.ui.theme.blue

//
// Created by MoaApps on 07/02/2025.
//



@Composable
fun DrawerView(modifier: Modifier, itemsList: List<DrawerItem>, onItemClick: (position: Int) -> Unit){

    var selectedItem by remember {
        mutableIntStateOf(0)
    }

    Column(
        modifier = modifier
            .fillMaxWidth(fraction = 0.8f)
            .fillMaxHeight()
            .background(Color.White)
    ) {

        DrawerHeader(modifier = Modifier)

        Spacer(modifier = Modifier.height(10.dp))

        for (item in itemsList) {
            val position = itemsList.indexOf(item)
            item.selected = selectedItem == position
            DrawerItem(
                modifier = Modifier
                    .clickable {
                        onItemClick(position)
                        selectedItem = position
                    },
                item = item
            )
        }

    }

}


@Composable
fun DrawerHeader(modifier: Modifier){

    Box (
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(blue)
            .padding(10.dp),
        contentAlignment = Alignment.BottomStart
    ) {

        Column {
            
            Icon(
                painter = painterResource(R.drawable.ic_t_letter),
                contentDescription = "Home",
                tint = Color.Black,
                modifier = Modifier.size(40.dp)
                    .graphicsLayer {
                        shadowElevation = 10f
                    }
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(5.dp)
                    )

                    .padding(5.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                "Translate",
                style = MaterialTheme.typography.titleSmall,
                color = Color.White
            )
            
        }

    }

}

@Composable
fun DrawerItem(modifier: Modifier, item: DrawerItem){
    Row (
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
            .background(
                color = if (item.selected) blue.copy(0.5f) else Color.Transparent,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(10.dp),

        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            painter = painterResource(id = item.icon),
            contentDescription = item.title,
            modifier = Modifier.size(30.dp)
        )
        Spacer(modifier.width(10.dp))

        Text(
            item.title,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun Preview(){
    TranslateTheme {
//        DrawerItem(modifier = Modifier, item = DrawerItem(R.drawable.ic_translate, "Translate", false))

//        DrawerHeader(modifier = Modifier)

        DrawerView(modifier = Modifier, itemsList = listOf(
            DrawerItem(R.drawable.ic_translate, "Translate", true),
            DrawerItem(R.drawable.ic_star, "Favourites", false),
        ), onItemClick = {

        })
    }
}