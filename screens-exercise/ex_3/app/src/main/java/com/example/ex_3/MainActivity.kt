package com.example.ex_3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color(0xFF4A7A7D)
            ) {
                CategoriesScreen()
            }
        }
    }
}

@Composable
fun CategoriesScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Cabeçalho
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color(0xFF5F8F8F)),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = "Categories",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        // Grid de Categorias
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                CategoryItem(
                    name = "Woman",
                    icon = Icons.Filled.Person,
                    backgroundColor = Color(0xFF739C9C),
                    modifier = Modifier.weight(1f)
                )
                CategoryItem(
                    name = "Man",
                    icon = Icons.Filled.Person,
                    backgroundColor = Color(0xFF5F8F8F),
                    modifier = Modifier.weight(1f)
                )
            }
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                CategoryItem(
                    name = "Baby",
                    icon = Icons.Filled.Face,
                    backgroundColor = Color(0xFF4F7E7E),
                    modifier = Modifier.weight(1f)
                )
                CategoryItem(
                    name = "Travel",
                    icon = Icons.Filled.Place,
                    backgroundColor = Color(0xFF3F6E6E),
                    modifier = Modifier.weight(1f)
                )
            }
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                CategoryItem(
                    name = "Tech",
                    icon = Icons.Filled.Settings,
                    backgroundColor = Color(0xFF2F5E5E),
                    modifier = Modifier.weight(1f)
                )
                CategoryItem(
                    name = "Food & Drink",
                    icon = Icons.Filled.ShoppingCart,
                    backgroundColor = Color(0xFF1F4E4E),
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}



@Composable
fun CategoryItem(
    name: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(4.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                imageVector = icon,
                contentDescription = name,
                tint = Color.White,
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = name,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Categories Preview"
)
@Composable
fun CategoriesPreview() {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFF507F7F)
        ) {
            CategoriesScreen()
        }
    }
}
