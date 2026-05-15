package com.example.contractorestimatepro.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.contractorestimatepro.domain.PricingEngine
import com.example.contractorestimatepro.domain.model.EstimateResult

@Composable
fun InputScreen(
    onEstimateCalculated: (EstimateResult) -> Unit
) {
    var laborHours by remember { mutableStateOf("") }
    var hourlyRate by remember { mutableStateOf("") }
    var materialsCost by remember { mutableStateOf("") }
    var profitMargin by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Contractor Estimate Pro",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        OutlinedTextField(
            value = laborHours,
            onValueChange = { laborHours = it },
            label = { Text("Labor Hours") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = hourlyRate,
            onValueChange = { hourlyRate = it },
            label = { Text("Hourly Rate ($)") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = materialsCost,
            onValueChange = { materialsCost = it },
            label = { Text("Materials Cost ($)") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = profitMargin,
            onValueChange = { profitMargin = it },
            label = { Text("Profit Margin (%)") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp)
        )

        Button(
            onClick = {
                val hours = laborHours.toDoubleOrNull() ?: 0.0
                val rate = hourlyRate.toDoubleOrNull() ?: 0.0
                val materials = materialsCost.toDoubleOrNull() ?: 0.0
                val margin = profitMargin.toDoubleOrNull() ?: 0.0

                val estimate = PricingEngine.calculateEstimate(
                    laborHours = hours,
                    hourlyRate = rate,
                    materialsCost = materials,
                    profitMargin = margin
                )
                onEstimateCalculated(estimate)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Calculate Estimate", style = MaterialTheme.typography.labelLarge)
        }
    }
}
