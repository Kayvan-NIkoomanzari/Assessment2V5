package com.example.assessment2v5.ui.login


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assessment2v5.data.LoginRequest
import com.example.assessment2v5.data.DashboardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
//Injecting dependencies into the ViewModel using Hilt
@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: DashboardRepository
) : ViewModel() {

    private val _loginResult = MutableStateFlow<Result<String>>(Result.failure(Throwable()))
    val loginResult: StateFlow<Result<String>> = _loginResult
//Login function to call the repository
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


