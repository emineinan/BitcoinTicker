package com.example.bitcointicker.model.detail


import com.google.gson.annotations.SerializedName

data class Market(
    @SerializedName("has_trading_incentive")
    val hasTradingİncentive: Boolean?,
    @SerializedName("identifier")
    val identifier: String?,
    @SerializedName("name")
    val name: String?
)