package com.goodluckys.binlistapp.data.remote.dto

data class CardCountryDTO(
    val numeric: String,
    val alpha2: String,
    val name: String,
    val emoji: String,
    val currency: String,
    val latitude: Int,
    val longitude: Int,
)