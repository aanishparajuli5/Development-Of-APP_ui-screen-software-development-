package com.example.teacher

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.teacher.ui.theme.TeacherTheme

data class InstagramStory(
    val title: String,
    val imageRes: Int
)

@Composable
fun InstagramProfileScreen(
    onBackClick: () -> Unit = {}
) {
    val scrollState = rememberScrollState()
    val storyList = listOf(
        InstagramStory("Story 1", R.drawable.aa),
        InstagramStory("Story 2", R.drawable.bb),
        InstagramStory("Story 3", R.drawable.aa),
        InstagramStory("Story 4", R.drawable.bb),
        InstagramStory("Story 5", R.drawable.aa)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .statusBarsPadding()
            .verticalScroll(scrollState)
    ) {
        // Top Navigation Bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.Black
                )
            }

            Text(
                text = "Anish parajuli",
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )

            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Default.MoreHoriz,
                    contentDescription = "More",
                    tint = Color.Black
                )
            }
        }

        // Profile Picture & Stats Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Gradient Ring Avatar
            val instagramGradient = Brush.linearGradient(
                colors = listOf(
                    Color(0xFFDE0046),
                    Color(0xFFF7A34B)
                )
            )

            Box(
                modifier = Modifier
                    .size(90.dp)
                    .border(3.dp, instagramGradient, CircleShape)
                    .padding(4.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.aa),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            }

            // Stats Columns
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                StatColumn(number = "10", label = "Posts")
                StatColumn(number = "1000", label = "Followers")
                StatColumn(number = "50", label = "Following")
            }
        }

        // Bio Section
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 4.dp)
        ) {
            Text(
                text = "Iceeee",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )

            Spacer(modifier = Modifier.height(2.dp))

            // Multi-line description with colored hashtag
            val bioText = buildAnnotatedString {
                append("i know u ")
                withStyle(SpanStyle(color = Color(0xFF00376B), fontWeight = FontWeight.SemiBold)) {
                    append("#hashtag")
                }
            }
            Text(
                text = bioText,
                color = Color.Black,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(2.dp))

            // Link text
            Text(
                text = "Link goes here",
                color = Color(0xFF00376B),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Followed by text
            val followedByText = buildAnnotatedString {
                append("Followed by ")
                withStyle(SpanStyle(fontWeight = FontWeight.Bold, color = Color.Black)) {
                    append("username")
                }
                append(" and ")
                withStyle(SpanStyle(fontWeight = FontWeight.Bold, color = Color.Black)) {
                    append("username")
                }
            }
            Text(
                text = followedByText,
                color = Color.DarkGray,
                fontSize = 13.sp
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Action Buttons Section
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Full Width Top Button
            OutlinedButton(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(38.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black),
                border = ButtonDefaults.outlinedButtonBorder.copy(brush = Brush.horizontalGradient(listOf(Color.LightGray, Color.LightGray)))
            ) {
                Text(text = "Button", fontWeight = FontWeight.Bold, fontSize = 14.sp)
            }

            // Row of Action Buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Follow Button (Primary Blue)
                Button(
                    onClick = { },
                    modifier = Modifier
                        .weight(1f)
                        .height(36.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF0095F6),
                        contentColor = Color.White
                    ),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(text = "Follow", fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                }

                // Message Button
                OutlinedButton(
                    onClick = { },
                    modifier = Modifier
                        .weight(1f)
                        .height(36.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black),
                    border = ButtonDefaults.outlinedButtonBorder.copy(brush = Brush.horizontalGradient(listOf(Color.LightGray, Color.LightGray))),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(text = "Message", fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                }

                // Email Button
                OutlinedButton(
                    onClick = { },
                    modifier = Modifier
                        .weight(1f)
                        .height(36.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black),
                    border = ButtonDefaults.outlinedButtonBorder.copy(brush = Brush.horizontalGradient(listOf(Color.LightGray, Color.LightGray))),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(text = "Email", fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                }

                // Dropdown Button
                OutlinedButton(
                    onClick = { },
                    modifier = Modifier
                        .size(36.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black),
                    border = ButtonDefaults.outlinedButtonBorder.copy(brush = Brush.horizontalGradient(listOf(Color.LightGray, Color.LightGray))),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "Dropdown",
                        tint = Color.Black,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Stories Row
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(storyList) { story ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .size(68.dp)
                            .border(1.dp, Color.LightGray, CircleShape)
                            .padding(3.dp)
                    ) {
                        Image(
                            painter = painterResource(id = story.imageRes),
                            contentDescription = story.title,
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = story.title,
                        color = Color.Black,
                        fontSize = 12.sp
                    )
                }
            }
        }
    }
}

@Composable
private fun StatColumn(number: String, label: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = number,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        Text(
            text = label,
            color = Color.Black,
            fontSize = 13.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun InstagramProfilePreview() {
    TeacherTheme(darkTheme = false) {
        InstagramProfileScreen()
    }
}
