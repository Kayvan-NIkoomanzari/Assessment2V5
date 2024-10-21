package com.example.assessment2v5.data
import com.example.assessment2v5.network.RestfulApiDevService


import com.example.assessment2v5.network.RestfulApiDevRetrofitClient
import javax.inject.Inject

class DashboardRepository @Inject constructor(
    restfulApiDevRetrofitClient: RestfulApiDevRetrofitClient
) {
    private val apiService = restfulApiDevRetrofitClient.apiService

    suspend fun login(loginRequest: LoginRequest) = apiService.login(loginRequest)
    suspend fun getDashboardData(keypass: String) = apiService.getDashboardData(keypass)
}