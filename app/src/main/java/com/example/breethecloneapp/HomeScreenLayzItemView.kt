package com.example.breethecloneapp

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.breethecloneapp.ui.theme.splashFont
import com.example.breethecloneapp.utils.exhaustive


@Composable
fun HomeScreenLazyItemView(itemName:String,navController: NavController) {

    val context = LocalContext.current



    Box(modifier = Modifier
        .size(width = 300.dp, height = 80.dp)
        .padding(top = 15.dp, end = 15.dp)
        .background(
            color = Color.Transparent, shape = RoundedCornerShape(40.dp)
        )
        .border(
            border = BorderStroke(width = 2.dp, color = Color(0xffe8f0ce)),
            shape = RoundedCornerShape(40.dp)
        )
        .clickable {

            Log.d("mal", "HomeScreenLazyItemView: ${itemName} ${context} ")

            when (itemName) {
                HomeScreenLazyItemData.options[0]->{

                    navController.navigate(Routes.SleepFirst){
                        popUpTo(Routes.Home){
                            inclusive = true
                        }
                    }

                }
//                HomeScreenLazyItemData.options[1]->{
//
//                }
//                HomeScreenLazyItemData.options[2]->{
//
//                }
//                HomeScreenLazyItemData.options[3]->{
//
//                }
//                HomeScreenLazyItemData.options[4]->{
//
//                }
//                HomeScreenLazyItemData.options[6]->{
//
//                }

             else ->   Toast.makeText(context,itemName,Toast.LENGTH_SHORT).show()

            }



        }){
        Text(text = itemName, fontFamily = splashFont, fontWeight = FontWeight.Normal,

            color = Color(0xffe8f0ce), modifier = Modifier.padding(start = 20.dp, top = 20.dp),

           fontSize = 20.sp

            )
    }
}