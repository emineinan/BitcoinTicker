package com.example.bitcointicker.ui.list

import com.example.bitcointicker.base.BaseRepository
import com.example.bitcointicker.network.ApiFactory
import javax.inject.Inject

class ListRepository @Inject constructor(private val apiFactory: ApiFactory) : BaseRepository() {
    suspend fun getData() = safeApiRequest {
        apiFactory.getData()
    }
}