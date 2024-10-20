package com.example.assessment2v5.data
import com.squareup.moshi.Json
data class LoginResponse(
    @Json(name = "keypass") val keypass: String
)
