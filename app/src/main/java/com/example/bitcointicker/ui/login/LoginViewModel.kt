package com.example.bitcointicker.ui.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val auth: FirebaseAuth,
) : ViewModel() {
    val isLogin: MutableLiveData<Boolean> = MutableLiveData()

    fun login(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                isLogin.value = true
            }
            .addOnFailureListener {
                isLogin.value = false
                Log.e("ERROR", it.message.toString())
            }
    }
}