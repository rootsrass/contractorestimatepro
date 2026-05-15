package com.example.contractorestimatepro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.contractorestimatepro.ui.InputScreen
import com.example.contractorestimatepro.ui.ResultScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val showResult = remember { mutableStateOf(false) }
            val estimateResult = remember { mutableStateOf<com.example.contractorestimatepro.domain.model.EstimateResult?>(null) }

            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                if (!showResult.value) {
                    InputScreen(
                        onEstimate = { result ->
                            estimateResult.value = result
                            showResult.value = true
                        }
                    )
                } else {
                    ResultScreen(
                        result = estimateResult.value,
                        onBack = {
                            showResult.value = false
                        }
                    )
                }
            }
        }
    }
}
