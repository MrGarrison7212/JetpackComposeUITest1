package com.example.jetpackcomposeuitest1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposeuitest1.ui.theme.JetpackComposeUITest1Theme
import androidx.constraintlayout.compose.ConstraintLayout


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeUITest1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    profile()
                }
            }
        }
    }
}

@Preview
@Composable
fun profile() {
    Column(
        Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(color = Color(android.graphics.Color.parseColor("#ececec"))),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ConstraintLayout() {
            val (topImg, profile) = createRefs()
            Image(
                painterResource(id = R.drawable.top_background),
                null,
                Modifier
                    .fillMaxWidth()
                    .constrainAs(topImg) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    })
            Image(
                painterResource(id = R.drawable.avatar),
                null,
                Modifier
                    .constrainAs(profile) {
                        top.linkTo(topImg.bottom)
                        bottom.linkTo(topImg.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    })
        }
    }
}