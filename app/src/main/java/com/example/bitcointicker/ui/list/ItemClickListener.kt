package com.example.bitcointicker.ui.list

import com.example.bitcointicker.model.list.Coin

interface ItemClickListener {
    fun onItemClick(coin: Coin)
}