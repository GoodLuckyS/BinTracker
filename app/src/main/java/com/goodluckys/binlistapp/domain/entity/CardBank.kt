package com.goodluckys.binlistapp.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CardBank(
    val name: String,
    val url: String,
    val phone: String,
    val city: String,
) : Parcelable