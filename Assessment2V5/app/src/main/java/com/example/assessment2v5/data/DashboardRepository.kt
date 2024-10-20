package com.example.assessment2v5.data
import com.example.assessment2v5.network.RestfulApiDevService
/*class DashboardRepository {
}*/

/*@Singleton
class DashboardRepository(private val apiService: RestfulApiDevService) {

    suspend fun login(loginRequest: LoginRequest): LoginResponse {
        return apiService.login(loginRequest)
    }

    suspend fun getDashboardData(keypass: String): DashboardResponse {
        return apiService.getDashboardData(keypass)
    }
}*/

/*
class DashboardRepository(private val apiService: RestfulApiDevService){
    suspend fun login(loginRequest: LoginRequest) = apiService.login(loginRequest)
    suspend fun getDashboardData(keypass: String) = apiService.getDashboardData(keypass)
}*/
/*
import javax.inject.Inject

class DashboardRepository @Inject constructor(
    private val apiService: RestfulApiDevService
) {
    suspend fun login(loginRequest: LoginRequest) = apiService.login(loginRequest)
    suspend fun getDashboardData(keypass: String) = apiService.getDashboardData(keypass)
}*/
import com.example.assessment2v5.network.RestfulApiDevRetrofitClient
import javax.inject.Inject

class DashboardRepository @Inject constructor(
    restfulApiDevRetrofitClient: RestfulApiDevRetrofitClient
) {
    private val apiService = restfulApiDevRetrofitClient.apiService

    suspend fun login(loginRequest: LoginRequest) = apiService.login(loginRequest)
    suspend fun getDashboardData(keypass: String) = apiService.getDashboardData(keypass)
}