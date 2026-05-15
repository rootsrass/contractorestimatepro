package com.example.contractorestimatepro.domain.model

data class EstimateResult(
    val adjustedSqft: Double,
    val materialCost: Double,
    val laborCost: Double,
    val removalCost: Double,
    val profit: Double,
    val total: Double
)