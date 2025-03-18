package com.restaurant.tip_calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.restaurant.tip_calculator.model.TipViewModel
import com.restaurant.tip_calculator.ui.theme.Tip_calculatorTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Tip_calculatorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TipCalculatorApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TipCalculatorApp(
    modifier: Modifier = Modifier,
    viewModel: TipViewModel = viewModel()
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.LightGray)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.DarkGray)
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Tip Calculator",
                color = Color.White,
                style = MaterialTheme.typography.titleLarge
            )
        }


        // Amount Input
        OutlinedTextField(
            value = viewModel.amount,
            onValueChange = { viewModel.updateAmount(it) },
            label = { Text("Amount") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Gray,
                unfocusedBorderColor = Color.Gray,
                cursorColor = Color.DarkGray,
                unfocusedPlaceholderColor = Color.Gray,
                focusedLabelColor = Color.Gray,
                unfocusedLabelColor = Color.LightGray
            )
        )


        // Custom Tip Slider
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "   Custom %")
        Slider(
            value = viewModel.customTipPercentage.toFloat(),
            onValueChange = { viewModel.updateCustomTip(it.toInt()) },
            valueRange = 0f..30f,
            steps = 29,
            colors = androidx.compose.material3.SliderDefaults.colors(
                thumbColor = Color.Gray,
                activeTrackColor = Color.DarkGray
            )
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "   0%")
            Text(text = "${viewModel.customTipPercentage}%")
            Text(text = "30%  ")
        }

        // Tip and Total Row
        Spacer(modifier = Modifier.height(14.dp))
        TipTotalRow(
            label = "   Tip       ",
            fixedTip = viewModel.fixedTip,
            customTip = viewModel.customTip
        )
        TipTotalRow(
            label = "   Total    ",
            fixedTip = viewModel.totalWithFixedTip,
            customTip = viewModel.totalWithCustomTip
        )
    }
}

@Composable
fun TipTotalRow(label: String, fixedTip: String, customTip: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label)
        Row {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(4.dp)
                    .background(Color.Gray)
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(fixedTip)
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(4.dp)
                    .background(Color.DarkGray)
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(customTip, color = Color.White)
            }
        }
    }
}
