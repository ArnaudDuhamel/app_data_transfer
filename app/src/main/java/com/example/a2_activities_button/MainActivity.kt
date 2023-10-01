package com.example.a2_activities_button

import android.annotation.SuppressLint
import android.content.Intent
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.a2_activities_button.ui.theme._2_activities_buttonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _2_activities_buttonTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    MainContent()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainContent() {
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Main Activity",
                                            color = Color.White)},
                              colors = TopAppBarDefaults.smallTopAppBarColors(Color(0xff0f9d58))) },
        content = { MyContent() }
    )
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyContent(){

    val mContext = LocalContext.current
    var message = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "The text you enter in this box will be printed in the second activity.",
            fontSize = 35.sp,
            color = Color(0xff0f9d58),
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Justify,
            lineHeight = 1.25.em,
            modifier = Modifier.width(350.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))
        OutlinedTextField(
            value = message.value,
            onValueChange = { message.value = it },
            colors = TextFieldDefaults.outlinedTextFieldColors(textColor = Color.Black,
                                                               focusedBorderColor = Color(0xff0f9d58),
                                                                unfocusedBorderColor = Color(0xff0f9d58))
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = {
            val navigate = Intent(mContext, MainActivity2::class.java)
            navigate.putExtra("message", message.value)
            mContext.startActivity(navigate)
        },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0XFF0F9D58)),
            shape = RectangleShape
        ){
            Text(text = "Go to second activity", color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainContent()
}