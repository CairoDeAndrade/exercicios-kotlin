package com.example.bookdetails

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exc6.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                BookDetailScreen()
            }
        }
    }
}

@Composable
fun BookDetailScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Capa do livro
        Row(
            verticalAlignment = Alignment.Top,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.book_cover), // Substituir pela imagem do livro
                contentDescription = "Book Cover",
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Gray),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text("The Silkworm", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text("Robert Galbraith", fontSize = 16.sp, color = Color.Gray)
                Text("June 19, 2014", fontSize = 14.sp, color = Color.Gray)

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E88E5))
                ) {
                    Text("READ", color = Color.White)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Ícones circulares
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            CircularIcon("4.0", "Stars")
            CircularIcon("Moving &", "Holders")
            CircularIcon("Similar", "")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Descrição do livro
        Text(
            "Private investigator Cormoran Strike returns in a new mystery from Robert Galbraith, author of the #1 international bestseller The Cuckoo’s Calling.",
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            "READ MORE",
            fontSize = 14.sp,
            color = Color(0xFF1E88E5),
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun CircularIcon(title: String, subtitle: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color(0xFF1E88E5), shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(title, color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(subtitle, fontSize = 12.sp, color = Color.Gray)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    MaterialTheme {
        BookDetailScreen()
    }
}