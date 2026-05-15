package com.example.contractorestimatepro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.contractorestimatepro.domain.model.EstimateResult
import com.example.contractorestimatepro.ui.InputScreen
import com.example.contractorestimatepro.ui.ResultScreen
import androidx.compose.material3.MaterialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                var result by remember { mutableStateOf<EstimateResult?>(null) }

                if (result == null) {
                    InputScreen(
                        onCalculate = { result = it }
                    )
                } else {
                    ResultScreen(
                        result = result!!,
                        onBack = { result = null }
                    )
                }
            }
        }
    }
}
