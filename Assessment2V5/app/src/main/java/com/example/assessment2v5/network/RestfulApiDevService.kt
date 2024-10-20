package com.example.assessment2v5.network

import com.example.assessment2v5.data.LoginRequest
import com.example.assessment2v5.data.LoginResponse
import com.example.assessment2v5.data.DashboardResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
interface RestfulApiDevService {

    @POST("/footscray/auth")
    suspend fun login(@Body requestBody: LoginRequest): LoginResponse

    @GET("/dashboard/{keypass}")
    suspend fun getDashboardData(@Path("keypass") keypass: String): DashboardResponse
}