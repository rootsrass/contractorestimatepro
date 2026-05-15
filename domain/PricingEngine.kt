package com.example.contractorestimatepro.domain

import com.example.contractorestimatepro.domain.model.EstimateResult
import kotlin.math.round

object PricingEngine {

    /**
     * Calculate a contractor estimate based on labor, materials, and profit margin
     *
     * @param laborHours Number of hours of labor required
     * @param hourlyRate Hourly rate for labor
     * @param materialsCost Total cost of materials
     * @param profitMargin Desired profit margin as a percentage (0-100)
     * @return EstimateResult with detailed breakdown
     */
    fun calculateEstimate(
        laborHours: Double,
        hourlyRate: Double,
        materialsCost: Double,
        profitMargin: Double
    ): EstimateResult {
        // Calculate labor cost
        val laborCost = laborHours * hourlyRate

        // Calculate subtotal (labor + materials)
        val subtotal = laborCost + materialsCost

        // Calculate profit based on margin percentage
        val profit = subtotal * (profitMargin / 100.0)

        // Calculate total estimate
        val totalEstimate = subtotal + profit

        return EstimateResult(
            laborCost = round(laborCost * 100) / 100,
            materialsCost = round(materialsCost * 100) / 100,
            subtotal = round(subtotal * 100) / 100,
            profit = round(profit * 100) / 100,
            totalEstimate = round(totalEstimate * 100) / 100,
            profitMarginPercent = profitMargin
        )
    }
}
