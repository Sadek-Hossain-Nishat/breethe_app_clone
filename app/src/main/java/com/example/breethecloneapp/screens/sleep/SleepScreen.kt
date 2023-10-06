package com.example.breethecloneapp.screens.sleep

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.breethecloneapp.R
import com.example.breethecloneapp.ui.theme.splashFont


@Composable
fun SleepScreen() {


    Box(modifier = with(Modifier) {
        fillMaxSize()
            .paint(
                painterResource(id = R.drawable.splash_background)
                ,
                contentScale = ContentScale.FillBounds

            )


    }) {

    }



    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Spacer(modifier = Modifier.height(20.dp))


            Text(text ="Puff", fontSize = 35.sp, fontFamily = splashFont, fontWeight = FontWeight.SemiBold ,color = colorResource(
                id = R.color.splashtextcolor
            )
            )


        }

    }







}

