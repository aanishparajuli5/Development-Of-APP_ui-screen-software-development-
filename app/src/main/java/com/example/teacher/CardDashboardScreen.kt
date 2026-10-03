package com.example.teacher

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.teacher.ui.theme.TeacherTheme

data class CategoryGridItem(
    val title: String,
    val countText: String,
    val icon: ImageVector,
    val iconColor: Color
)

data class ListCardItem(
    val title: String,
    val subtitle: String,
    val description: String = "",
    val extraText: String = "",
    val bgBrush: Brush
)

val MintGreen = Color(0xFF10CE99)
val DarkMint = Color(0xFF0EA97E)

@Composable
fun CardDashboardScreen() {
    var selectedTab by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF6F8F7))
            .statusBarsPadding()
    ) {
        // Toggle view tab
        TabRow(
            selectedTabIndex = selectedTab,
            containerColor = MintGreen,
            contentColor = Color.White,
            indicator = { tabPositions ->
                TabRowDefaults.SecondaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTab]),
                    color = Color.White
                )
            }
        ) {
            Tab(
                selected = selectedTab == 0,
                onClick = { selectedTab = 0 },
                text = { Text("Grid View", fontWeight = FontWeight.Bold) }
            )
            Tab(
                selected = selectedTab == 1,
                onClick = { selectedTab = 1 },
                text = { Text("List View", fontWeight = FontWeight.Bold) }
            )
        }

        if (selectedTab == 0) {
            GridViewContent()
        } else {
            ListViewContent()
        }
    }
}

@Composable
private fun GridViewContent() {
    val gridItems = listOf(
        CategoryGridItem("Text", "11 items content", Icons.Default.Book, Color(0xFFE53935)),
        CategoryGridItem("Address", "3 items content", Icons.Default.Home, Color(0xFFE53935)),
        CategoryGridItem("Character", "15 items content", Icons.Default.Badge, Color(0xFFFB8C00)),
        CategoryGridItem("Bank card", "5 items content", Icons.Default.CreditCard, Color(0xFF1E88E5)),
        CategoryGridItem("Password", "21 items content", Icons.Default.Key, Color(0xFFFFB300)),
        CategoryGridItem("Logistics", "10 items content", Icons.Default.LocalShipping, Color(0xFF43A047))
    )

    Column(modifier = Modifier.fillMaxSize()) {
        // Header Section
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MintGreen)
                .padding(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Card",
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Simple and easy to use app",
                        color = Color.White.copy(alpha = 0.85f),
                        fontSize = 14.sp
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.aa),
                    contentDescription = "User Avatar",
                    modifier = Modifier
                        .size(44.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            }
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(gridItems) { item ->
                Card(
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(140.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .size(48.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(item.iconColor.copy(alpha = 0.1f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.title,
                                tint = item.iconColor,
                                modifier = Modifier.size(28.dp)
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = item.title,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp
                        )

                        Text(
                            text = item.countText,
                            color = Color.Gray,
                            fontSize = 11.sp
                        )
                    }
                }
            }
        }

        // Bottom Settings Card
        Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF1E88E5).copy(alpha = 0.1f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "Settings",
                        tint = Color(0xFF1E88E5),
                        modifier = Modifier.size(22.dp)
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                Column {
                    Text(
                        text = "Settings",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                    )
                    Text(
                        text = "Fingerprint code and so on",
                        color = Color.Gray,
                        fontSize = 12.sp
                    )
                }
            }
        }
    }
}

@Composable
private fun ListViewContent() {
    val cards = listOf(
        ListCardItem(
            title = "Dribbble",
            subtitle = "Paidax",
            description = "*********",
            bgBrush = Brush.horizontalGradient(listOf(Color(0xFFFFB300), Color(0xFFFF8F00)))
        ),
        ListCardItem(
            title = "HJM",
            subtitle = "173****8838",
            bgBrush = Brush.horizontalGradient(listOf(Color(0xFF29B6F6), Color(0xFF0288D1)))
        ),
        ListCardItem(
            title = "Tom",
            subtitle = "Room 601, Building 8, Zhongnan Century City, No.8, Taoyuan Road...",
            description = "130****3920",
            bgBrush = Brush.horizontalGradient(listOf(Color(0xFF26A69A), Color(0xFF00897B)))
        ),
        ListCardItem(
            title = "1882 **** **** 8695",
            subtitle = "ICBC",
            description = "Debit Card",
            extraText = "12/19",
            bgBrush = Brush.horizontalGradient(listOf(Color(0xFF7E57C2), Color(0xFF512DA8)))
        ),
        ListCardItem(
            title = "Young",
            subtitle = "This is the story of me and them, very...",
            bgBrush = Brush.horizontalGradient(listOf(Color(0xFFEF5350), Color(0xFFD32F2F)))
        ),
        ListCardItem(
            title = "Jinjun street, golden chrysanthemum Road, Haizhu District...",
            subtitle = "Saved location",
            bgBrush = Brush.horizontalGradient(listOf(Color(0xFF26C6DA), Color(0xFF00ACC1)))
        )
    )

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            // Header Section
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MintGreen)
                    .padding(20.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Card",
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Image(
                        painter = painterResource(id = R.drawable.aa),
                        contentDescription = "User Avatar",
                        modifier = Modifier
                            .size(44.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                }
            }

            // Cards List
            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(cards) { card ->
                    Card(
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(card.bgBrush)
                                .padding(16.dp)
                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = card.title,
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )

                                Text(
                                    text = card.subtitle,
                                    color = Color.White.copy(alpha = 0.9f),
                                    fontSize = 13.sp,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )

                                if (card.description.isNotEmpty()) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Text(
                                            text = card.description,
                                            color = Color.White.copy(alpha = 0.8f),
                                            fontSize = 12.sp
                                        )
                                        if (card.extraText.isNotEmpty()) {
                                            Text(
                                                text = card.extraText,
                                                color = Color.White.copy(alpha = 0.8f),
                                                fontSize = 12.sp
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // Floating Action Button (+)
        FloatingActionButton(
            onClick = { },
            containerColor = MintGreen,
            contentColor = Color.White,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(24.dp)
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add Card")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardDashboardPreview() {
    TeacherTheme(darkTheme = false) {
        CardDashboardScreen()
    }
}
