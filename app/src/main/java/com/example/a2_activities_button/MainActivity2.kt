package com.example.a2_activities_button

import android.annotation.SuppressLint
import android.content.Intent
import android.content.Intent.getIntent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.a2_activities_button.ui.theme._2_activities_buttonTheme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _2_activities_buttonTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainContent2()
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    public fun MainContent2(modifier: Modifier = Modifier) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Second Activity",
                            color = Color.White
                        )
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = Color(
                            0xff0f9d58
                        )
                    )
                )
            },
            content = { MyContent2() }
        )
    }

    @Composable
    fun MyContent2() {

        val mContext = LocalContext.current

        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = intent.getStringExtra("message") ?: "No message found",
                fontSize = 35.sp,
                color = Color(0xff0f9d58),
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                lineHeight = 1.25.em,
                modifier = Modifier.width(350.dp)
            )
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = {
                    mContext.startActivity(Intent(mContext, MainActivity::class.java))
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0XFF0F9D58)),
            ) {
                Text(text = "Go back to first activity", color = Color.White)
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview2() {
        MainContent2()
    }

}