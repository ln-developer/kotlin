package models

import kotlinx.serialization.Serializable

@Serializable
data class DataResponse(
    val EUR: Double,
    val GBP: Double,
    val USD: Double,
)