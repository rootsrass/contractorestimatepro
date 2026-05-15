package com.example.contractorestimatepro.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.contractorestimatepro.domain.PricingEngine
import com.example.contractorestimatepro.domain.model.EstimateResult

@Composable
fun InputScreen(
    onEstimate: (EstimateResult) -> Unit
) {
    val laborHours = remember { mutableStateOf("") }
    val hourlyRate = remember { mutableStateOf("") }
    val materialsCost = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Contractor Estimate Pro")
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = laborHours.value,
            onValueChange = { laborHours.value = it },
            label = { Text("Labor Hours") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = hourlyRate.value,
            onValueChange = { hourlyRate.value = it },
            label = { Text("Hourly Rate ($)") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = materialsCost.value,
            onValueChange = { materialsCost.value = it },
            label = { Text("Materials Cost ($)") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                val hours = laborHours.value.toDoubleOrNull() ?: 0.0
                val rate = hourlyRate.value.toDoubleOrNull() ?: 0.0
                val materials = materialsCost.value.toDoubleOrNull() ?: 0.0

                val result = PricingEngine.calculateEstimate(hours, rate, materials)
                onEstimate(result)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calculate Estimate")
        }
    }
}
