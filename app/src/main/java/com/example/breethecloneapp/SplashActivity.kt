package com.example.breethecloneapp

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.activity.compose.setContent
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
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.breethecloneapp.puffnavhost.PuffNavHost
import com.example.breethecloneapp.screens.sleep.SleepScreenWelcomeScreen
import com.example.breethecloneapp.ui.theme.splashFont
import kotlinx.coroutines.delay


lateinit var mediaplayer:MediaPlayer

class SplashActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mediaplayer = MediaPlayer.create(this,R.raw.splashscreenbackgroundmusic)
//        Toast.makeText(this,"brethe app",Toast.LENGTH_SHORT).show()



//        lifecycleScope.launchWhenCreated {
//            mediaplayer.start()
//
//            delay(15000)
//            mediaplayer.stop()
//            val intent = Intent(this@SplashActivity,MainActivity::class.java)
//            startActivity(intent)
//            finish()
//        }

        setContent {

//            SplashScreen(
//                mediaplayer = mediaplayer
//            )

//            PuffApp()

            SleepScreenWelcomeScreen()



        }

    }





}


@Composable
fun PuffApp() {

    val navController  = rememberNavController()
    PuffNavHost(navcontroller = navController)





}


@Composable
fun SplashScreen(

    navController: NavController
                ) {



val activity = LocalContext.current as Activity
    
    
    LaunchedEffect(key1 = true ){
        mediaplayer.start()
        delay(15000)

        navController.navigate(Routes.Home){
            mediaplayer.stop()
            popUpTo(Routes.Splash){
                inclusive = true
            }
        }
    }

    val onBack ={


        mediaplayer.stop()
        activity.finish()
    }

    BackPressHandler(onBackPressed = onBack)

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

        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

            Image(painter = painterResource(id = R.drawable.plogo), contentDescription ="plogo",
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp))
            Spacer(modifier = Modifier.height(10.dp))
            Text(text ="Puff", fontSize = 35.sp, fontFamily = splashFont, fontWeight = FontWeight.SemiBold ,color = colorResource(
                id = R.color.splashtextcolor
            ))


        }

    }




}


@Composable
fun BackPressHandler(
    backPressedDispatcher: OnBackPressedDispatcher? = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher,
    onBackPressed: ()->Unit
) {

    val currentOnBackPressed by rememberUpdatedState(newValue =onBackPressed )

    val backCallback = remember{
        object :OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
               currentOnBackPressed()
            }
        }
    }

    DisposableEffect(key1 = backPressedDispatcher ){
        backPressedDispatcher?.addCallback(backCallback)

        onDispose {
            backCallback.remove()
        }

    }


    
}


//important link

//https://www.valueof.io/blog/intercept-back-press-button-in-jetpack-compose#:~:text=In%20a%20nutshell%2C%20we%20create,responsible%20for%20back%20press%20handling.

