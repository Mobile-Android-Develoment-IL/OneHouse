package com.example.onehouse.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onehouse.repository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthViewModel(private val repository: AuthRepository) : ViewModel() {
    private val _signInResult = MutableStateFlow<Result<Boolean>?>(null)
    val signInResult: StateFlow<Result<Boolean>?> = _signInResult

    private val _registerResult = MutableStateFlow<Result<Boolean>?>(null)
    val registerResult: StateFlow<Result<Boolean>?> = _registerResult

    fun signIn(email: String, password: String) {
        viewModelScope.launch {
            val result = repository.signIn(email, password)
            _signInResult.value = result
        }
    }

    fun register(email: String, password: String) {
        viewModelScope.launch {
            val result = repository.register(email, password)
            _registerResult.value = result
        }
    }
}