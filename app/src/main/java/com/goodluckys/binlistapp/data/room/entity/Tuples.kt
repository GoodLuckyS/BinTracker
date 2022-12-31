package com.goodluckys.binlistapp.data.room.entity

data class CardBankTuple(
    val name: String,
    val url: String,
    val phone: String,
    val city: String,
)

data class CardNumberTuple(
    val length: String,
    val luhn: String,
)