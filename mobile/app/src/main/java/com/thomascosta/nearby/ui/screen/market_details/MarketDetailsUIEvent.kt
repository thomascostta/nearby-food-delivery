package com.thomascosta.nearby.ui.screen.market_details

sealed class MarketDetailsUIEvent {
    data class OnFetchRules(val marketId: String) : MarketDetailsUIEvent()
    data class OnFetchCoupon(val qrCodeContent: String) : MarketDetailsUIEvent()
    data object OnResetCoupon : MarketDetailsUIEvent()
}