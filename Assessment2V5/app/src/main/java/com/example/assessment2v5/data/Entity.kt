package com.example.assessment2v5.data
import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize
@Parcelize
data class Entity(
    @Json(name = "assetType") val assetType: String,
    @Json(name = "ticker") val ticker: String,
    @Json(name = "currentPrice") val currentPrice: Double?,
    @Json(name = "dividendYield") val dividendYield: Double?,
    @Json(name = "description") val description: String
) : Parcelable