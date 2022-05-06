package com.example.bitcointicker.model.detail


import com.google.gson.annotations.SerializedName

data class CurrentPrice(
    @SerializedName("usd")
    val usd: Double?,
)