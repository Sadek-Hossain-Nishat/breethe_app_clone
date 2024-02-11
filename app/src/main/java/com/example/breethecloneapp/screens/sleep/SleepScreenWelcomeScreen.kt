package com.example.breethecloneapp.screens.sleep


import android.util.Log
import android.widget.Toast
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ExperimentalTextApi

import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withAnnotation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.MotionLayout


import androidx.navigation.NavController
import com.example.breethecloneapp.R
import com.example.breethecloneapp.Routes
import com.example.breethecloneapp.mediaplayer
import com.example.breethecloneapp.ui.theme.splashFont
import kotlinx.coroutines.delay




@Composable
fun SleepScreenWelcomeScreen(
    navController: NavController
) {


    val context = LocalContext.current


    Box(modifier = with(Modifier) {

        fillMaxSize()
            .paint(
                painterResource(id = R.drawable.splash_background),
                contentScale = ContentScale.FillBounds

            )


    }

    ) {


    }


    // on below line we are specifying animate button method.
    var animateButton by remember { mutableStateOf(false) }
    // on below line we are specifying button animation progress
    val buttonAnimationProgress by animateFloatAsState(

        // specifying target value on below line.
        targetValue = if (animateButton) 1f else 0f,

        // on below line we are specifying
        // animation specific duration's 1 sec
        animationSpec = tween(1000)
    )



    LaunchedEffect(key1 = true) {

        delay(1000)

        animateButton = !animateButton
    }


    // on below line we are creating a motion layout.
    MotionLayout(
        // in motion layout we are specifying 2 constraint
        // set for two different positions of buttons.
        // in first constraint set we are specifying width,
        // height start, end and top position of buttons.
        ConstraintSet(
            """ {
                // on below line we are specifying width,height and margin
                // from start, top and end for button1
              img: {
              
                  width:100,
                  height: 100,
                  start: ['parent', 'start', 16],
                  end: ['parent', 'end', 16],
                  top: ['parent', 'top', 250],
                  
                 
                },
                
                text1: {
                
                start: ['parent', 'start', 16],
                  end: ['parent', 'end', 16],
                  top: ['img', 'top', 100],
                  
                
                },
                
                 text2: {
                
                start: ['parent', 'start', 16],
                  end: ['parent', 'end', 16],
                  top: ['text1', 'top', 1000],
                  
                
                },
                
                
                 text3: {
                
                start: ['parent', 'start', 16],
                  end: ['parent', 'end', 16],
                  top: ['text2', 'top', 1000],
                  
                
                },
                
                button: {
                 start: ['parent', 'start', 16],
                  end: ['parent', 'end', 16],
                  top: ['text3', 'top', 1000],
                  
                
                
                },
                
                   text4: {
                
                start: ['parent', 'start', 16],
                  end: ['parent', 'end', 16],
                  top: ['button', 'top', 1000],
                  
                
                }
                
                
                
                
                
                

            } """
        ),

        // in second constraint set we are specifying width,
        // height start, end and top position of buttons.
        ConstraintSet(
            """ {
                // on below line we are specifying width,height and margin
                // from start, top and end for button1
                
                img: {
                  width: 100,
                  height: 100,
                  start: ['parent', 'start', 30],
                  end: ['parent', 'end', 10],
                  top: ['parent','top',-150]
                },

                
                 text1: {
                
                start: ['parent', 'start', 16],
                  end: ['parent', 'end', 16],
                  top: ['parent', 'top', 50],
                  
                
                }
                
                
                ,
                
                  text2: {
                
                start: ['parent', 'start', 16],
                  end: ['parent', 'end', 16],
                  top: ['text1', 'top', 200],
                  
                
                },
                
                
                 text3: {
                
                start: ['parent', 'start', 16],
                  end: ['parent', 'end', 16],
                  top: ['text2', 'top', 60],
                  
                
                },
                
                button: {
                 start: ['parent', 'start', 16],
                  end: ['parent', 'end', 16],
                  top: ['text3', 'top', 200],
                  
                
                
                },
                
                   text4: {
                
                start: ['parent', 'start', 16],
                  end: ['parent', 'end', 16],
                  top: ['button', 'top', 70],
                  
                
                }
                
                
                

            } """
        ),
        // on below line we are specifying
        // progress for button animation
        progress = buttonAnimationProgress,
        // on below line we are specifying modifier
        // for filling max width and content height.
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        // on below line we are creating  a button.
        Image(
            painter = painterResource(id = R.drawable.plogo), contentDescription = "plogo",
            modifier = Modifier.layoutId("img")
        )

        Text(
            text = "Puff",
            fontSize = 40.sp,
            fontFamily = splashFont,
            fontWeight = FontWeight.Normal,
            color = colorResource(
                id = R.color.splashtextcolor
            ),
            modifier = Modifier.layoutId("text1")
        )

        Text(
            text = "Get the best Sleep",
            fontSize = 35.sp,
            fontFamily = splashFont,
            fontWeight = FontWeight.SemiBold,
            color = colorResource(
                id = R.color.splashtextcolor
            ),
            modifier = Modifier.layoutId("text2")
        )
        Text(
            text = "of your life!",
            fontSize = 35.sp,
            fontFamily = splashFont,
            fontWeight = FontWeight.SemiBold,
            color = colorResource(
                id = R.color.splashtextcolor
            ),
            modifier = Modifier.layoutId("text3")
        )

        Button(
            onClick = {

                navController.navigate(Routes.SleepAuthSignIn){
                    mediaplayer.stop()
                    popUpTo(Routes.Splash){
                        inclusive = true
                    }
                }



            }, shape = RoundedCornerShape(25.dp),
            modifier = Modifier
                .width(200.dp)
                .layoutId("button"),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,

                )
        ) {

            Text(text = "Get Started")


        }

        val annotatedString = buildAnnotatedString {
            append("Already a Puff user?")

            @OptIn(ExperimentalTextApi::class)
            withAnnotation("tag", "annotation") {


                withStyle(style = SpanStyle(Color.Blue)) {
                    append("Log in")
                }
            }
        }



        ClickableText(
            text = annotatedString,
            style = TextStyle(
                colorResource(
                    id = R.color.splashtextcolor
                ),
                fontSize = 20.sp
            ),


            modifier = Modifier.layoutId("text4")
        ) {
            annotatedString.getStringAnnotations(it, it).firstOrNull()?.tag?.let { tag ->
                Log.d("ClickableText", "$tag -th character is clicked.")
                Toast.makeText(context, "$tag -th character is clicked.", Toast.LENGTH_SHORT).show()
            }
        }


    }


}




