package com.example.contractorestimatepro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.material3.MaterialTheme
import com.example.contractorestimatepro.ui.*
import com.example.contractorestimatepro.domain.model.EstimateResult

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                var result by remember { mutableStateOf<EstimateResult?>(null) }

                if (result == null) {
                    InputScreen { result = it }
                } else {
                    ResultScreen(result!!) { result = null }
                }
            }
        }
    }
}