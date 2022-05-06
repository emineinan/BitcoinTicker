package com.example.bitcointicker.model.detail


import com.google.gson.annotations.SerializedName

data class İmage(
    @SerializedName("large")
    val large: String?,
    @SerializedName("small")
    val small: String?,
    @SerializedName("thumb")
    val thumb: String?
)