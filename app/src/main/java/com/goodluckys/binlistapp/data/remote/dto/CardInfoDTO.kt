package com.goodluckys.binlistapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CardInfoDTO(
    @SerializedName("number")
    val number: CardNumberDTO?,
    @SerializedName("scheme")
    val scheme: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("brand")
    val brand: String?,
    @SerializedName("prepaid")
    val prepaid: Boolean?,
    @SerializedName("country")
    val country: CardCountryDTO?,
    @SerializedName("bank")
    val bank: CardBankDTO?,
    )