package com.goodluckys.binlistapp.domain

import android.os.Parcelable
import com.goodluckys.binlistapp.domain.entity.CardBank
import com.goodluckys.binlistapp.domain.entity.CardNumber
import kotlinx.parcelize.Parcelize

@Parcelize
data class CardInfo(
    val id : Int,
    val bin:String,
    val number: CardNumber,
    val scheme: String,
    val type: String,
    val brand: String,
    val prepaid: String,
    val country: String,
    val bank: CardBank,
) : Parcelable

