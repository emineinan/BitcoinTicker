package com.example.bitcointicker.model.detail

import com.google.gson.annotations.SerializedName

data class MarketData(
    @SerializedName("current_price")
    val current_price: CurrentPrice,
    @SerializedName("price_change_percentage_24h")
    val price_change_percentage_24h: Double?
)
