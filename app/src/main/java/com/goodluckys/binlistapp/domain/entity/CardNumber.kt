package com.goodluckys.binlistapp.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class CardNumber(
    val length: String,
    val luhn: String,
) : Parcelable