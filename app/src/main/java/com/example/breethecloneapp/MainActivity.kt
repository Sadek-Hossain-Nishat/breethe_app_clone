package com.example.breethecloneapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.breethecloneapp.ui.theme.splashFont

class MainActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            
//            ReasonSelectionScreen()

        }
    }




}





@Composable
fun ReasonSelectionScreen(
    navController: NavController
) {

    Box(modifier = with(Modifier) {
        fillMaxSize()
            .paint(
                painterResource(id = R.drawable.splash_background)
                ,
                contentScale = ContentScale.FillBounds

            )


    }) {

    }




    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 15.dp, start = 35.dp), horizontalAlignment = Alignment.CenterHorizontally){


        Text(text = "What's the main reason you are here?", fontSize = 35.sp, fontFamily = splashFont,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xffe8f0ce))


        
        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn{
            items(HomeScreenLazyItemData.options){
                HomeScreenLazyItemView(itemName =it, navController =  navController)


            }
        }
    }

    
}



