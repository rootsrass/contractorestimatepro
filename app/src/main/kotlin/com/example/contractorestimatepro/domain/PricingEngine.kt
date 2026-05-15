package com.example.contractorestimatepro.domain

import com.example.contractorestimatepro.domain.model.EstimateResult

object PricingEngine {

    fun calculate(sqft: Int, sodPrice: Double, removalEnabled: Boolean): EstimateResult {

        val laborRate = 0.25
        val waste = 0.12
        val removalRate = 0.30
        val profitMargin = 0.20

        val adjusted = sqft + (sqft * waste)

        val material = adjusted * sodPrice
        val labor = adjusted * laborRate
        val removal = if (removalEnabled) adjusted * removalRate else 0.0

        val subtotal = material + labor + removal
        val profit = subtotal * profitMargin
        val total = subtotal + profit

        return EstimateResult(adjusted, material, labor, removal, profit, total)
    }
}