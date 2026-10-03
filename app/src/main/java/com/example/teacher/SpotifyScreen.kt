package com.example.teacher

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.teacher.ui.theme.TeacherTheme

data class SpotifyArtist(
    val name: String,
    val imageRes: Int
)

data class SpotifyCardItem(
    val title: String,
    val subtitle: String,
    val backgroundColor: Color,
    val imageRes: Int
)

@Composable
fun SpotifyScreen() {
    val scrollState = rememberScrollState()

    val recentlyPlayed = listOf(
        SpotifyArtist("Lana Del Rey", R.drawable.img_11),
        SpotifyArtist("Marvin Gaye", R.drawable.bb)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .statusBarsPadding()
            .padding(horizontal = 16.dp)
            .verticalScroll(scrollState)
    ) {
        Spacer(modifier = Modifier.height(12.dp))

        // Top Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Recently played",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Row {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = "Notifications",
                        tint = Color.White
                    )
                }
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.History,
                        contentDescription = "History",
                        tint = Color.White
                    )
                }
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "Settings",
                        tint = Color.White
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Recently Played Artists Row
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(recentlyPlayed) { artist ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = artist.imageRes),
                        contentDescription = artist.name,
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = artist.name,
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(28.dp))

        // Section: #SPOTIFYWRAPPED
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(Color(0xFFC3F53C)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "2021",
                    color = Color.Black,
                    fontWeight = FontWeight.Black,
                    fontSize = 12.sp
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(
                    text = "#SPOTIFYWRAPPED",
                    color = Color(0xFFB3B3B3),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Your 2021 in review",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Wrapped Grid (2 cards)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Card 1
            Column(modifier = Modifier.weight(1f)) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFFCCD965)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.scoott),
                        contentDescription = "Your Top Songs",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop,
                        alpha = 0.45f
                    )
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(12.dp)
                    ) {
                        Text(
                            text = "Your Top Songs",
                            color = Color(0xFF1E3264),
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                        Text(
                            text = "2021",
                            color = Color(0xFF1E3264),
                            fontWeight = FontWeight.Black,
                            fontSize = 32.sp
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Your Top Songs 2021",
                    color = Color.White,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            // Card 2
            Column(modifier = Modifier.weight(1f)) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFF8D82F5)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.one_d),
                        contentDescription = "Your Artists Revealed",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop,
                        alpha = 0.45f
                    )
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(12.dp)
                    ) {
                        Text(
                            text = "Your Artists",
                            color = Color(0xFF2213A3),
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                        Text(
                            text = "Revealed",
                            color = Color(0xFF2213A3),
                            fontWeight = FontWeight.Black,
                            fontSize = 20.sp
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Your Artists Revealed",
                    color = Color.White,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.height(28.dp))

        // Section: Editor's picks
        Text(
            text = "Editor's picks",
            color = Color.White,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Editor's picks Cards
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Pick 1
            Column(modifier = Modifier.weight(1f)) {
                Image(
                    painter = painterResource(id = R.drawable.edd),
                    contentDescription = "Ed Sheeran & Big Sean",
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Ed Sheeran, Big Sean, Juice WRLD, Post Malone",
                    color = Color(0xFFB3B3B3),
                    fontSize = 12.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }

            // Pick 2
            Column(modifier = Modifier.weight(1f)) {
                Image(
                    painter = painterResource(id = R.drawable.zayyy),
                    contentDescription = "Mitski, Tame Impala",
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Mitski, Tame Impala, Glass Animals, Charli XCX",
                    color = Color(0xFFB3B3B3),
                    fontSize = 12.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun SpotifyPreview() {
    TeacherTheme(darkTheme = true) {
        SpotifyScreen()
    }
}
