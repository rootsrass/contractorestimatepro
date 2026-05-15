package com.example.contractorestimatepro.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ResultScreen(
    result: com.example.contractorestimatepro.domain.model.EstimateResult,
    onBack: () -> Unit
) {

    Column(Modifier.padding(16.dp)) {

        Text("Result")

        Text("Total: ${result.total}")

        Button(onClick = onBack) {
            Text("Back")
        }
    }
}