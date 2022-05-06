package com.example.bitcointicker.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bitcointicker.model.detail.CoinDetail
import com.example.bitcointicker.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(private val repository: CoinDetailRepository) :
    ViewModel() {
    val detailResponse: MutableLiveData<CoinDetail?> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData(true)
    val onError: MutableLiveData<String?> = MutableLiveData()

    fun getDetail(id: String) = viewModelScope.launch {
        isLoading.value = true
        when (val request = repository.getDetail(id)) {
            is NetworkResult.Success -> {
                isLoading.value = false
                detailResponse.value = request.data
            }
            is NetworkResult.Error -> {
                isLoading.value = false
                onError.value = request.message
            }
        }
    }
}