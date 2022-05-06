package com.example.bitcointicker.model.detail


import com.google.gson.annotations.SerializedName

data class ConvertedLast(
    @SerializedName("btc")
    val btc: Double?,
    @SerializedName("eth")
    val eth: Double?,
    @SerializedName("usd")
    val usd: Int?
)