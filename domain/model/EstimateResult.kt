package com.example.contractorestimatepro.domain.model

data class EstimateResult(
    val laborCost: Double,
    val materialsCost: Double,
    val subtotal: Double,
    val profit: Double,
    val totalEstimate: Double,
    val profitMarginPercent: Double
)
