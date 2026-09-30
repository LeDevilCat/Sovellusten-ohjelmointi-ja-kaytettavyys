package com.example.harjoitus_01

data class Event(
    val id: Int,
    val name: String,
    val description: String,
    val location: String,
    val price: Float,
    val isFree: Boolean,
    val websiteUrl: String
)
