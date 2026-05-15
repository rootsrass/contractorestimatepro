package com.example.contractorestimatepro.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.contractorestimatepro.domain.model.EstimateResult

@Composable
fun ResultScreen(
    result: EstimateResult?,
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Estimate Result", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))

        if (result != null) {
            Text("Labor Cost: \$${String.format("%.2f", result.laborCost)}")
            Spacer(modifier = Modifier.height(8.dp))
            Text("Materials Cost: \$${String.format("%.2f", result.materialsCost)}")
            Spacer(modifier = Modifier.height(8.dp))
            Text("Total Estimate: \$${String.format("%.2f", result.totalEstimate)}", fontSize = 20.sp)
        }

        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back")
        }
    }
}
