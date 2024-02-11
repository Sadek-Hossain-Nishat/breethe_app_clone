package com.example.breethecloneapp.puffnavhost




import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.breethecloneapp.ReasonSelectionScreen
import com.example.breethecloneapp.Routes
import com.example.breethecloneapp.SplashScreen
import com.example.breethecloneapp.screens.sleep.SleepScreen
import com.example.breethecloneapp.screens.sleep.SleepScreenAuthScreen


import com.example.breethecloneapp.screens.sleep.SleepScreenWelcomeScreen

@Composable
fun PuffNavHost(
    navcontroller:NavHostController
) {

NavHost(navController = navcontroller, startDestination = Routes.Splash ){

    composable(route = Routes.Splash) {
        
        SplashScreen(navController = navcontroller)
        
    }

    composable(route = Routes.Home) { 
        ReasonSelectionScreen( navController = navcontroller)
    }
    
    
    composable(route = Routes.SleepFirst){
        SleepScreenWelcomeScreen(
            navController = navcontroller
        )}
    composable(route = Routes.SleepAuthSignIn){
        SleepScreenAuthScreen()
    }


}
    
}


// https://www.howtodoandroid.com/animated-splash-screen-in-android-jetpack-compose/