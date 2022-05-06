package com.example.bitcointicker.ui.detail

import com.example.bitcointicker.base.BaseRepository
import com.example.bitcointicker.network.ApiFactory
import javax.inject.Inject

class CoinDetailRepository @Inject constructor(private val apiFactory: ApiFactory) :
    BaseRepository() {
    suspend fun getDetail(id: String) = safeApiRequest {
        apiFactory.getDetail(id)
    }
}