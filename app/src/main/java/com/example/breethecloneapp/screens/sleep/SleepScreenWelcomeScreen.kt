package com.example.breethecloneapp.screens.sleep

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
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


@SuppressLint("SuspiciousIndentation")
@Composable
fun SleepScreenWelcomeScreen() {

//    var animationstart by rememberSaveable {
//        mutableStateOf(true)
//    }
//
//
//    val animationProgress by animateFloatAsState(targetValue =
//    if (animationstart) 1f else 0f,
//        animationSpec = tween(1000)
//    )
//
//
//
//    LaunchedEffect(key1 = true ){
//
//        delay(3000)
//
//        animationstart =  !animationstart
//    }
//
//

//
        Box(modifier = with(Modifier){

            fillMaxSize()
                .paint(
                    painterResource(id = R.drawable.splash_background)
                    ,
                    contentScale = ContentScale.FillBounds

                )


        }

        ) {



        }
//
//        Box(modifier = Modifier.fillMaxSize()
////            , contentAlignment = Alignment.Center
//        ) {
//
//            Column(
////                horizontalAlignment = Alignment.CenterHorizontally,
////                verticalArrangement = Arrangement.Center
//            ) {
//
////                Spacer(modifier = Modifier.height(10.dp))
//
//
//                MotionLayout(start = ConstraintSet (
//                    """
//                        {
//
//                        text1: {
//                        center: ['parent', 'center']
//                        }
//
//                        }
//                    """
//                ), end = ConstraintSet ("""
//
//
//                     {
//
//                        text1: {
//                        centerHorizontally: ['parent', 'center'],
//                        top: ['parent', 'top', 20]
//                        }
//
//                        }
//
//
//                """.trimIndent()), progress = animationProgress) {
//
//
//
//                    Text(text ="Puff", fontSize = 35.sp, fontFamily = splashFont, fontWeight = FontWeight.SemiBold ,color = colorResource(
//                        id = R.color.splashtextcolor
//                    ),
//                        modifier =  Modifier.layoutId("text1")
//                    )
//
//                }
//
//
//
//
//
//
//            }
//
//        }





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



    LaunchedEffect(key1 = true ){

        delay(3000)

        animateButton = ! animateButton
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
                button1: {
                  width:"spread",
                  height: 120,
                  start: ['parent', 'start', 16],
                  end: ['parent', 'end', 16],
                  top: ['parent', 'top', 300],
//                  center: ['parent','center']
                 
                },
                // on below line we are specifying width,height
                // and margin from start, top and end for button2
//                button2: {
//                  width: "spread",
//                  height: 120,
//                  start: ['parent', 'start', 16],
//                  end: ['parent', 'end', 16],
//                  top: ['button1', 'bottom', 16],
//                 
//                }
            } """
        ),

        // in second constraint set we are specifying width,
        // height start, end and top position of buttons.
        ConstraintSet(
            """ {
                // on below line we are specifying width,height and margin
                // from start, top and end for button1
                button1: {
                  width: "spread",
                  height: 120,
                  start: ['parent', 'start', 30],
                  end: ['parent', 'end', 10],
                  top: ['parent','top',50]
                },
                // on below line we are specifying width,height
                // and margin from start, top and end for button2
//                button2: {
//                  width: 150,
//                  height: 120,
//                  start: ['button1', 'end', 10],
//                  end: ['parent', 'end', 30]
//                }
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
        Button(
            // on below line we are adding on click.
            onClick = {
                // inside on click we are animating button
                // by simply changing animateButton variable
                animateButton = !animateButton
            },
            // on below line we are
            // specifying id for our button 1
            modifier = Modifier.layoutId("button1")
        ) {
            // on below line we are adding content
            // inside our button in the form of column.
            Column(
                // in this column we are specifying a
                // modifier with padding from all sides.
                modifier = Modifier
                    .padding(3.dp)
                    .fillMaxWidth()
                    .fillMaxHeight(),
                // on below line we are specifying vertical
                // and horizontal arrangement for our column
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // on the below line we are specifying an image inside our column
                Image(

                    // on below line we are specifying
                    // the drawable image for our image.
                    painter = painterResource(id = R.drawable.plogo),

                    // on below line we are specifying
                    // content description for our image
                    contentDescription = "Python",

                    // on below line we are setting
                    // height and width for our image.
                    modifier = Modifier
                        .height(60.dp)
                        .width(60.dp)
                )
                // on below line we are adding spacer/
                Spacer(modifier = Modifier.height(5.dp))

                // below spacer we are adding a
                // simple text for displaying a text
                Text(
                    text = "Python",
                    color = Color.White,
                    fontSize = TextUnit(value = 18F, type = TextUnitType.Sp)
                )
            }
        }


//        Button(
//            onClick = {
//                // inside on click we are animating button
//                // by simply changing animateButton variable
//                animateButton = !animateButton
//            },
//            // on below line we are specifying id for our button 2
//            modifier = Modifier.layoutId("button2")
//        ) {
//            Column(
//                // in this column we are specifying
//                // a modifier with padding from all sides.
//                modifier = Modifier
//                    .padding(3.dp)
//                    .fillMaxWidth()
//                    .fillMaxHeight(),
//                // on below line we are specifying vertical
//                // and horizontal arrangement for our column
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                // on below line we are specifying image inside our column
//                Image(
//                    // on below line we are specifying
//                    // the drawable image for our image.
//                    painter = painterResource(id = R.drawable.plogo),
//
//                    // on below line we are specifying
//                    // content description for our image
//                    contentDescription = "Javascript",
//
//                    // on below line we are setting
//                    // height and width for our image.
//                    modifier = Modifier
//                        .height(60.dp)
//                        .width(60.dp)
//                )
//                // on below line we are adding spacer/
//                Spacer(modifier = Modifier.height(5.dp))
//
//                // below spacer we are adding a
//                // simple text for displaying a text
//                Text(
//                    text = "JavaScript",
//                    color = Color.White,
//                    fontSize = TextUnit(value = 18F, type = TextUnitType.Sp)
//                )
//
//            }
//        }
    }




















    }




