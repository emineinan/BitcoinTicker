package com.example.bitcointicker.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bitcointicker.model.list.Coin
import com.example.bitcointicker.utils.NetworkResult.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val repository: ListRepository) : ViewModel() {

    val coinResponse: MutableLiveData<List<Coin>?> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData(true)
    val onError: MutableLiveData<String?> = MutableLiveData()

    fun getData() = viewModelScope.launch {
        isLoading.value = true
        when (val request = repository.getData()) {
            is Success -> {
                coinResponse.value = request.data
                isLoading.value = false
            }
            is Error -> {
                onError.value = request.message
                isLoading.value = false
            }
        }
    }
}