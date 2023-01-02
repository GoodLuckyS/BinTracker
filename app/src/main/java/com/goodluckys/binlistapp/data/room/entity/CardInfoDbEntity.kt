package com.goodluckys.binlistapp.data.room.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "card_info"
)
data class CardInfoDbEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val bin: String,
    @Embedded val number: CardNumberTuple,
    val scheme: String,
    val type: String,
    val brand: String,
    val prepaid: String,
    val country: String,
    @Embedded val bank: CardBankTuple,
)



