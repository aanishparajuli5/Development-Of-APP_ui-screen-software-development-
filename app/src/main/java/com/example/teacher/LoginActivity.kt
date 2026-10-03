package com.example.teacher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.teacher.ui.theme.TeacherTheme

class LoginActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginBody()
        }
    }

}

@Composable
fun LoginBody() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),

        ) {
        Text(
            "Hello", style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline,
                color = Color.Red,
                fontStyle = FontStyle.Italic
            )
        )
    }


}

@Preview
@Composable
fun LoginPreview() {
    LoginBody()
}