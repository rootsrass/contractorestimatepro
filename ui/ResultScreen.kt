package com.example.contractorestimatepro.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.contractorestimatepro.domain.model.EstimateResult
import java.text.DecimalFormat

@Composable
fun ResultScreen(
    estimate: EstimateResult,
    onBackPressed: () -> Unit
) {
    val currencyFormat = DecimalFormat("$#,##0.00")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Header with back button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBackPressed) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
            }
            Text(
                "Estimate Details",
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        // Results Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                ResultRow("Labor Cost", currencyFormat.format(estimate.laborCost))
                Divider(modifier = Modifier.padding(vertical = 8.dp))
                ResultRow("Materials Cost", currencyFormat.format(estimate.materialsCost))
                Divider(modifier = Modifier.padding(vertical = 8.dp))
                ResultRow("Subtotal", currencyFormat.format(estimate.subtotal))
                Divider(modifier = Modifier.padding(vertical = 8.dp))
                ResultRow("Profit", currencyFormat.format(estimate.profit))
                Divider(modifier = Modifier.padding(vertical = 8.dp))
                ResultRow(
                    "Total Estimate",
                    currencyFormat.format(estimate.totalEstimate),
                    isTotal = true
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = onBackPressed,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Create New Estimate")
        }
    }
}

@Composable
fun ResultRow(
    label: String,
    value: String,
    isTotal: Boolean = false
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            label,
            style = if (isTotal) MaterialTheme.typography.titleLarge else MaterialTheme.typography.bodyLarge
        )
        Text(
            value,
            style = if (isTotal) MaterialTheme.typography.titleLarge else MaterialTheme.typography.bodyLarge
        )
    }
}
