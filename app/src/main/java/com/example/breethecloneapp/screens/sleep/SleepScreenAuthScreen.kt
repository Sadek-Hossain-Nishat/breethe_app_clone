
package com.example.breethecloneapp.screens.sleep

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.AnimationVector
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.TwoWayConverter
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.animation.core.animateValueAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults


import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.breethecloneapp.R
import com.example.breethecloneapp.Routes
import com.example.breethecloneapp.mediaplayer
import com.example.breethecloneapp.ui.theme.splashFont
import com.example.breethecloneapp.utils.clearFocusOnKeyboardDismiss
import com.example.breethecloneapp.utils.rememberImeState
import kotlinx.coroutines.delay

import kotlin.math.roundToInt


@Composable
fun SleepScreenAuthScreen() {



    Box(modifier = with(Modifier) {

        fillMaxSize()
            .paint(
                painterResource(id = R.drawable.splash_background),
                contentScale = ContentScale.FillBounds

            )


    }

    ) {


    }



    val configuration = LocalConfiguration.current
   /***
    val heightInDp = configuration.screenHeightDp.dp
    val halfheightInDp = (configuration.screenHeightDp*0.6).dp

    ***/



    var moved by remember { mutableStateOf(false) }
    var headComponentmoved by remember { mutableStateOf(false) }
    val pxToMove = with(LocalDensity.current) {
        100.dp.toPx().roundToInt()
    }
    val offset by animateDpAsState(
        targetValue = if (moved) {
            (configuration.screenHeightDp*0.35).dp

        } else {
            (configuration.screenHeightDp*0.40).dp
        },
        label = "offset",
        animationSpec = tween(2000, easing = LinearOutSlowInEasing)
    )
    val headComponentoffset by animateDpAsState(
        targetValue = if (headComponentmoved) {
            (configuration.screenHeightDp*0.05).dp

        } else {
            (configuration.screenHeightDp*0.10).dp
        },
        label = "offset",
        animationSpec = tween(2000, easing = LinearOutSlowInEasing)
    )

    var textvisible by remember {
        mutableStateOf(false)
    }

    var headComponenetvisible by remember {
        mutableStateOf(false)
    }



    var name by remember {
        mutableStateOf("")
    }



    val btnvisible:Boolean by animateValueAsState (
        targetValue = if(name.isBlank()){
            false
        }else{
            true
        },
        label = "btnvisible",
        typeConverter = TwoWayConverter(
            convertFromVector ={true} ,
            convertToVector = { AnimationVector(0f) }
        ),
        animationSpec = tween(100, easing = FastOutLinearInEasing)

    )

    val imeState by rememberUpdatedState( rememberImeState())
    val scrollState = rememberScrollState()



    LaunchedEffect(key1 = imeState.value) {
        if (imeState.value){
            scrollState.animateScrollTo(scrollState.maxValue, tween(300))
        }
    }



    LaunchedEffect(key1 = true) {









        textvisible = !textvisible



        delay(2000)


        moved = !moved
        delay(2000)
        textvisible = !textvisible
        delay(2000)
        headComponenetvisible  = !headComponenetvisible
        delay(2000)
        headComponentmoved = !headComponentmoved



    }





    Column(modifier = Modifier
        .verticalScroll(scrollState)
        .fillMaxSize()

        , horizontalAlignment= Alignment.CenterHorizontally) {

//        Box(modifier = Modifier.fillMaxWidth()) {
//            Column() {
//                Text()
//
//            }
//
//        }


        
        Spacer(modifier = Modifier.height(50.dp))

        AnimatedVisibility( visible =headComponenetvisible,
            enter =  fadeIn(
                // Fade in with the initial alpha of 0.3f.
                animationSpec = tween(2000,easing= LinearEasing)
            ),

            modifier= Modifier.offset(y = headComponentoffset),
            ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Column {


                    Text(
                        text = "Hello,friend\nWhat's your name?",
                        fontSize = 35.sp,
                        fontFamily = splashFont,
                        fontWeight = FontWeight.SemiBold,
                        color = colorResource(
                            id = R.color.splashtextcolor
                        ),
                        //                modifier = Modifier.offset(y= offset),

                    )

                    //                Spacer(modifier = Modifier.height(20.dp))
                    Spacer(modifier = Modifier.height(20.dp))



                    TextField(
                      modifier =   Modifier.clearFocusOnKeyboardDismiss(),
                        value = name,
                        onValueChange = { name = it },
                        placeholder = {
                            Text(
                                text = "Your Name",
                                fontSize = 20.sp,
                                color = Color.LightGray,
                                fontWeight = FontWeight.SemiBold,
                            )
                        },
                        textStyle = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.SemiBold),

                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = colorResource(
                                id = R.color.textfieldcolor
                            ),
                            focusedContainerColor = colorResource(
                                id = R.color.textfieldcolor
                            ),
                            cursorColor = Color.LightGray,
                            unfocusedTextColor = Color.LightGray,
                            focusedTextColor = Color.LightGray,


                            )

                    )


                }
            }
        }





        AnimatedVisibility(
            visible =textvisible,
            enter =  fadeIn(
                // Fade in with the initial alpha of 0.3f.
                animationSpec = tween(2000,easing= LinearEasing)
            ),

            modifier= Modifier.offset(y = offset),
            exit = fadeOut(

                animationSpec = tween(2000,easing= LinearEasing)


            )



            ) {


           Text(
                text = "Welcome to\nPuff",
                fontSize = 35.sp,
                fontFamily = splashFont,
                fontWeight = FontWeight.SemiBold,
                color = colorResource(
                    id = R.color.splashtextcolor
                ),

                style = TextStyle(textAlign = TextAlign.Center)
            )

        }

       Spacer(modifier = Modifier.height(300.dp))



        AnimatedVisibility(
//            visible =btnvisible,
            visible =true,
            enter =  fadeIn(
                // Fade in with the initial alpha of 0.3f.
                animationSpec = tween(100,easing= FastOutLinearInEasing)
            ),

//            modifier= Modifier.offset(y = (configuration.screenHeightDp*0.50).dp),
            exit = fadeOut(

                animationSpec = tween(100,easing= FastOutLinearInEasing)


            )




        ) {


            Button(
                onClick = {





                }, shape = RoundedCornerShape(25.dp),
                modifier = Modifier
                    .width(200.dp)
                    ,
                colors = ButtonDefaults.buttonColors(
                    containerColor =colorResource(
                        id = R.color.authbtncolor
                    ),

                    )
            ) {

                Text(text = "Get Started")


            }




        }











    }



}