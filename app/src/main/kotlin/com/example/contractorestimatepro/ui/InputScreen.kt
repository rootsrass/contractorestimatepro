package com.example.contractorestimatepro.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

@Composable
fun InputScreen(onResult: (com.example.contractorestimatepro.domain.model.EstimateResult) -> Unit) {

    var sqft by remember { mutableStateOf("") }
    var sod by remember { mutableStateOf("Bahia") }
    var removal by remember { mutableStateOf(false) }

    val prices = mapOf(
        "Bahia" to 0.35,
        "St Augustine" to 0.45,
        "Zoysia" to 0.55
    )

    var expanded by remember { mutableStateOf(false) }

    Column(Modifier.padding(16.dp)) {

        Text("Contractor Estimate Pro")

        OutlinedTextField(
            value = sqft,
            onValueChange = { sqft = it },
            label = { Text("Square Footage") }
        )

        Spacer(Modifier.height(12.dp))

        Button(onClick = { expanded = true }) {
            Text(sod)
        }

        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            prices.keys.forEach {
                DropdownMenuItem(
                    text = { Text(it) },
                    onClick = {
                        sod = it
                        expanded = false
                    }
                )
            }
        }

        Row {
            Checkbox(checked = removal, onCheckedChange = { removal = it })
            Text("Removal Required")
        }

        Spacer(Modifier.height(20.dp))

        Button(onClick = {
            val sqftInt = sqft.toIntOrNull() ?: 0
            val result = com.example.contractorestimatepro.domain.PricingEngine.calculate(
                sqftInt,
                prices[sod]!!
,
                removal
            )
            onResult(result)
        }) {
            Text("Calculate")
        }
    }
}