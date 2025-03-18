package com.restaurant.tip_calculator.model

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import java.text.NumberFormat

class TipViewModel : ViewModel() {

    var amount by mutableStateOf("")

    var customTipPercentage by mutableIntStateOf(18)

    private val fixedTipPercentage = 15

    val formattedAmount: String
        get() = formatCurrency(amount.toDoubleOrNull() ?: 0.0)

    val fixedTip: String
        get() = formatCurrency(calculateTip(fixedTipPercentage))

    val customTip: String
        get() = formatCurrency(calculateTip(customTipPercentage))

    val totalWithFixedTip: String
        get() = formatCurrency((amount.toDoubleOrNull() ?: 0.0) + calculateTip(fixedTipPercentage))

    val totalWithCustomTip: String
        get() = formatCurrency((amount.toDoubleOrNull() ?: 0.0) + calculateTip(customTipPercentage))

    fun updateAmount(value: String) {
        amount = value
    }

    fun updateCustomTip(value: Int) {
        customTipPercentage = value
    }

    private fun calculateTip(percentage: Int): Double {
        val baseAmount = amount.toDoubleOrNull() ?: 0.0
        return baseAmount * (percentage / 100.0)
    }

    private fun formatCurrency(value: Double): String {
        return NumberFormat.getCurrencyInstance().format(value)
    }
}
