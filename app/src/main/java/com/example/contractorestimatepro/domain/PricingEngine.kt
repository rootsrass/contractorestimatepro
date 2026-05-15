package com.example.contractorestimatepro.domain

import com.example.contractorestimatepro.domain.model.EstimateResult

object PricingEngine {
    fun calculateEstimate(
        laborHours: Double,
        hourlyRate: Double,
        materialsCost: Double
    ): EstimateResult {
        val laborCost = laborHours * hourlyRate
        val totalEstimate = laborCost + materialsCost

        return EstimateResult(
            laborCost = laborCost,
            materialsCost = materialsCost,
            totalEstimate = totalEstimate
        )
    }
}
