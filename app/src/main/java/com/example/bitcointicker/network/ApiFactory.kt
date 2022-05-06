package com.example.bitcointicker.network

import com.example.bitcointicker.model.detail.CoinDetail
import com.example.bitcointicker.model.list.Coin
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiFactory {

    @GET("coins/markets?vs_currency=usd")
    suspend fun getData(
    ): List<Coin>

    @GET("coins/{id}")
    suspend fun getDetail(
        @Path("id") id: String,
    ): CoinDetail

}