package com.example.assessment2v5.data

import com.squareup.moshi.Json
data class DashboardResponse(
    val entities: List<Entity>,
    val entityTotal: Int
)
