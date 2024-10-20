package com.example.assessment2v5.ui.login

/*
import androidx.lifecycle.ViewModel
import com.example.assessment2v5.data.LoginRequest
import com.example.assessment2v5.data.LoginResponse
import com.example.assessment2v5.data.DashboardRepository

class LoginViewModel(private val repository: DashboardRepository) : ViewModel() {

    suspend fun login(loginRequest: LoginRequest): LoginResponse? {
        return try {
            repository.login(loginRequest)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}*/

/*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assessment2v5.data.LoginRequest
import com.example.assessment2v5.data.LoginResponse
import com.example.assessment2v5.network.RestfulApiDevRetrofitClient
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val _loginResult = MutableLiveData<Result<String>>()
    val loginResult: LiveData<Result<String>> = _loginResult

    fun login(username: String, password: String) {
        viewModelScope.launch {
            try {
                val loginRequest = LoginRequest(username, password)
                val response: LoginResponse = RestfulApiDevRetrofitClient().apiService.login(loginRequest)
                _loginResult.value = Result.success(response.keypass)
            } catch (e: Exception) {
                _loginResult.value = Result.failure(e)
            }
        }
    }
}*/

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assessment2v5.data.LoginRequest
import com.example.assessment2v5.data.DashboardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: DashboardRepository
) : ViewModel() {

    private val _loginResult = MutableStateFlow<Result<String>>(Result.failure(Throwable()))
    val loginResult: StateFlow<Result<String>> = _loginResult

    fun login(username: String, password: String) {
        viewModelScope.launch {
            try {
                val loginRequest = LoginRequest(username, password)
                val response = repository.login(loginRequest)
                _loginResult.value = Result.success(response.keypass)
            } catch (e: Exception) {
                _loginResult.value = Result.failure(e)
            }
        }
    }
}


