package com.example.bitcointicker.model.detail


import com.google.gson.annotations.SerializedName

data class PublicİnterestStats(
    @SerializedName("alexa_rank")
    val alexaRank: Int?,
    @SerializedName("bing_matches")
    val bingMatches: Any?
)