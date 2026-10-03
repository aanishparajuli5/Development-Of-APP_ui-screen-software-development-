package com.example.teacher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.teacher.ui.theme.TeacherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TeacherTheme {
                MainAppScreen()
            }
        }
    }
}

@Composable
fun MainAppScreen() {
    var selectedScreenIndex by remember { mutableIntStateOf(0) }

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = selectedScreenIndex == 0,
                    onClick = { selectedScreenIndex = 0 },
                    icon = { Icon(Icons.Default.Person, contentDescription = "Instagram Profile") },
                    label = { Text("Instagram") }
                )
                NavigationBarItem(
                    selected = selectedScreenIndex == 1,
                    onClick = { selectedScreenIndex = 1 },
                    icon = { Icon(Icons.Default.MusicNote, contentDescription = "Spotify") },
                    label = { Text("Spotify") }
                )
                NavigationBarItem(
                    selected = selectedScreenIndex == 2,
                    onClick = { selectedScreenIndex = 2 },
                    icon = { Icon(Icons.Default.CreditCard, contentDescription = "Card Manager") },
                    label = { Text("Cards") }
                )
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (selectedScreenIndex) {
                0 -> InstagramProfileScreen()
                1 -> SpotifyScreen()
                2 -> CardDashboardScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainAppPreview() {
    TeacherTheme {
        MainAppScreen()
    }
}
