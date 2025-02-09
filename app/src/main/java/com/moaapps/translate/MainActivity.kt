package com.moaapps.translate

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.moaapps.translate.models.DrawerItem
import com.moaapps.translate.ui.theme.TranslateTheme
import com.moaapps.translate.ui.views.DrawerView
import com.moaapps.translate.ui.views.MainView
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TranslateTheme {

                val drawerState = rememberDrawerState(initialValue = DrawerValue.Open)
                var selectedItem by remember {
                    mutableIntStateOf(0)
                }

                val coroutineScope = rememberCoroutineScope()

                LaunchedEffect(key1 = selectedItem) {
                    drawerState.close()
                }

                val itemsList = listOf(
                    DrawerItem(R.drawable.ic_translate, "Translate", true),
                    DrawerItem(R.drawable.ic_star, "Favourites", false),
                    DrawerItem(R.drawable.ic_history, "History", false),
                )


                ModalNavigationDrawer(
                    drawerContent = {
                        DrawerView(
                            modifier = Modifier,
                            itemsList = itemsList,
                            onItemClick = {
                                selectedItem = it
                            }
                        )
                    },

                    drawerState = drawerState,
                    gesturesEnabled = true,

                ) {

                    Scaffold(modifier = Modifier.fillMaxSize()) {
                        MainView {
                            coroutineScope.launch {
                                drawerState.open()
                            }
                        }
                    }
                }



            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TranslateTheme {

    }
}