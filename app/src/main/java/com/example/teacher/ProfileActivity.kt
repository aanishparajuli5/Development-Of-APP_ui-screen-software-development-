package com.example.teacher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AlternateEmail
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.outlined.PersonAdd
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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

// Data model for individual highlight stories
data class HighlightStory(
    val title: String,
    @param:DrawableRes val imageResId: Int
)

class ProfileActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            TeacherTheme(darkTheme = false) {
                ProfileBody()
            }
        }
    }
}


@Composable
fun ProfileBody() {
    val backgroundColor = Color.White
    val buttonColor = Color(0xFFEFEFEF)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .statusBarsPadding()
    ) {

        // Top bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Back icon
            Icon(
                painter = painterResource(R.drawable.baseline_arrow_back_ios_24),
                contentDescription = "Back",
                tint = Color.Black,
                modifier = Modifier.size(20.dp)
            )

            // Centered Username
            Text(
                text = "iceeeyy",
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )

            // Balance spacer for center alignment
            Spacer(modifier = Modifier.size(20.dp))
        }


        // Profile Header section
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Profile picture
            Image(
                painter = painterResource(R.drawable.aa),
                contentDescription = "Profile picture",
                modifier = Modifier
                    .size(82.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            // User Info & Stats Column
            Column(
                modifier = Modifier.weight(1f)
            ) {

                // Username & More options row
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "iceee",
                        color = Color.Black,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Icon(
                        painter = painterResource(R.drawable.baseline_more_horiz_24),
                        contentDescription = "More options",
                        tint = Color.Black,
                        modifier = Modifier.size(20.dp)
                    )
                }

                Spacer(modifier = Modifier.height(2.dp))

                // Display Name in Devanagari
                Text(
                    text = "aaa",
                    color = Color.Black,
                    fontSize = 15.sp
                )

                Spacer(modifier = Modifier.height(10.dp))

                // Stats row (Posts, Followers, Following)
                Text(
                    text = buildAnnotatedString {
                        withStyle(SpanStyle(fontWeight = FontWeight.Bold, color = Color.Black)) {
                            append("6 ")
                        }
                        withStyle(SpanStyle(color = Color.Black)) {
                            append("posts   ")
                        }
                        withStyle(SpanStyle(fontWeight = FontWeight.Bold, color = Color.Black)) {
                            append("429 ")
                        }
                        withStyle(SpanStyle(color = Color.Black)) {
                            append("followers   ")
                        }
                        withStyle(SpanStyle(fontWeight = FontWeight.Bold, color = Color.Black)) {
                            append("387 ")
                        }
                        withStyle(SpanStyle(color = Color.Black)) {
                            append("following")
                        }
                    },
                    fontSize = 14.sp
                )
            }
        }
        // Bio Section
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            // Threads handle
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.AlternateEmail,
                    contentDescription = "Threads",
                    tint = Color.Black,
                    modifier = Modifier.size(16.dp)
                )

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = "icee",
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Action Buttons Row (Following, Message, Add Person)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Following button
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(36.dp)
                    .background(buttonColor, RoundedCornerShape(8.dp))
                    .clickable { },
                contentAlignment = Alignment.Center
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Following",
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = null,
                        tint = Color.Black,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }

            // Message button
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(36.dp)
                    .background(buttonColor, RoundedCornerShape(8.dp))
                    .clickable { },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Message",
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp
                )
            }

            // Add person icon button
            Box(
                modifier = Modifier
                    .size(height = 36.dp, width = 36.dp)
                    .background(buttonColor, RoundedCornerShape(8.dp))
                    .clickable { },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Outlined.PersonAdd,
                    contentDescription = "Add Person",
                    tint = Color.Black,
                    modifier = Modifier.size(18.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // List of highlights where each item has its own image resource
        val highlights = listOf(
            HighlightStory(title = "😍", imageResId = R.drawable.aa),
            HighlightStory(title = "Highlights", imageResId = R.drawable.aa),
            HighlightStory(title = "Highlights", imageResId = R.drawable.bb)
        )

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(highlights) { story ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .size(68.dp)
                            .border(1.5.dp, Color(0xFFDBDBDB), CircleShape)
                            .padding(3.dp)
                    ) {
                        // Dynamically load story.imageResId
                        Image(
                            painter = painterResource(story.imageResId),
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


@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    TeacherTheme(darkTheme = false) {
        ProfileBody()
    }
}
