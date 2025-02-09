package com.moaapps.translate.ui.views

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TranslationView(){

    val sourceLangState = rememberTextFieldState()

    val devicePaddingValues = WindowInsets.systemBars.asPaddingValues()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Column(
            modifier = Modifier.weight(1f)

        ) {

            //Source Lang View

            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                blue,
                                Color.White,
                                Color.White
                            )
                        )
                    )
                    .background(
                        lightGray,
                        shape = RoundedCornerShape(
                            bottomEnd = 50.dp,
                            topStart = 50.dp
                        )
                    )
                    .padding(20.dp)

            ){

                Row (
                    modifier = Modifier
                        .fillMaxWidth(),

                    verticalAlignment = Alignment.CenterVertically

                ){

                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors().copy(
                            containerColor = Color.Transparent,
                            contentColor = darkBlue
                        ),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_wireless),
                            contentDescription = "",
                            modifier = Modifier.size(20.dp)
                        )
                    }

                    Text(
                        text = "English",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Spacer(modifier = Modifier.weight(1f))


                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors().copy(
                            containerColor = Color.Transparent,
                            contentColor = darkBlue
                        )
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_close),
                            contentDescription = "Clear Text",
                            modifier = Modifier.size(20.dp)
                        )
                    }


                }

                Box (
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .padding(15.dp)
                ){
                    BasicTextField2(
                        state = sourceLangState,
                        textStyle = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.fillMaxSize()
                    )

                    if (sourceLangState.text.isEmpty()){
                        Text(
                            text = "Enter text to translate",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Gray
                        )
                    }
                }


            }


            // Target lang view

            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                lightGray,
                                Color.White,
                            )
                        )
                    )
                    .background(
                        Color.White,
                        shape = RoundedCornerShape(
                            topStart = 50.dp
                        )
                    )
                    .padding(20.dp)
            ){

                Row (
                    modifier = Modifier
                        .fillMaxWidth(),

                    verticalAlignment = Alignment.CenterVertically

                ){

                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors().copy(
                            containerColor = Color.Transparent,
                            contentColor = darkBlue
                        ),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_wireless),
                            contentDescription = "",
                            modifier = Modifier.size(20.dp)
                        )
                    }

                    Text(
                        text = "Arabic",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Spacer(modifier = Modifier.weight(1f))


                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors().copy(
                            containerColor = Color.Transparent,
                            contentColor = darkBlue
                        ),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_star),
                            contentDescription = "Favorite",
                            modifier = Modifier.size(20.dp)
                        )
                    }

                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors().copy(
                            containerColor = Color.Transparent,
                            contentColor = darkBlue
                        ),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_copy),
                            contentDescription = "Favorite",
                            modifier = Modifier.size(20.dp)
                        )
                    }


                }


                Text(
                    text = "Translated text",
                    style = MaterialTheme.typography.bodyMedium,
                    color = darkBlue,
                    modifier = Modifier
                        .padding(15.dp)
                )



            }

        }


        Box (
            modifier = Modifier
                .shadow(
                    elevation = 30.dp,
                    spotColor = Color.Black,
                    ambientColor = Color.Black,
                    shape = RoundedCornerShape(
                        topEnd = 60.dp,
                        topStart = 60.dp
                    )
                )
                .fillMaxWidth()
                .height(60.dp + devicePaddingValues.calculateBottomPadding())
                .background(Color.White)
                .navigationBarsPadding()
        ){

            Row(
                modifier = Modifier
                    .fillMaxSize(),
            ) {

                //source lang btn
                Button(
                    onClick = {  },
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                        .background(lightGray),
                    colors = ButtonDefaults.buttonColors().copy(
                        containerColor = Color.Transparent
                    )
                ) {

                    Text(
                        text = "English",
                        style = MaterialTheme.typography.titleMedium,
                        color = darkBlue
                    )
                    
                }

                //target lang btn
                Button(
                    onClick = {  },
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                        .background(blue),
                    colors = ButtonDefaults.buttonColors().copy(
                        containerColor = Color.Transparent
                    )
                ) {

                    Text(
                        text = "Arabic",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White
                    )

                }



            }

            //switch lang btn

            Button(
                onClick = {  },
                modifier = Modifier
                    .aspectRatio(1f)
                    .background(
                        Color.White,
                        shape = RoundedCornerShape(50.dp)
                    )
                    .align(Alignment.Center),
                colors = ButtonDefaults.buttonColors().copy(
                    containerColor = Color.Transparent,
                    contentColor = darkBlue
                ),

                contentPadding = PaddingValues(15.dp)
            ) {

                Icon(
                    painter = painterResource(id = R.drawable.ic_switch),
                    contentDescription = "switch languages",
                )

            }

        }

    }

}

@Preview(showSystemUi = true)
@Composable
fun TranslationViewPreview(){
    TranslateTheme {
        TranslationView()
    }
}