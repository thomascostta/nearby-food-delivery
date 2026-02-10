package com.thomascosta.nearby.ui.screen.market_details

import com.thomascosta.nearby.data.model.Rule

data class MarketDetailsUIState(
    val rules: List<Rule>? = null,
    val coupon: String? = null
)