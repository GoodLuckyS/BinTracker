package com.goodluckys.binlistapp.data.room

import com.goodluckys.binlistapp.data.UNDEF_ID
import com.goodluckys.binlistapp.data.room.entity.CardBankTuple
import com.goodluckys.binlistapp.data.room.entity.CardInfoDbEntity
import com.goodluckys.binlistapp.data.room.entity.CardNumberTuple
import com.goodluckys.binlistapp.domain.CardInfo
import com.goodluckys.binlistapp.domain.entity.CardBank
import com.goodluckys.binlistapp.domain.entity.CardNumber


fun CardInfoDbEntity.toDomain() = CardInfo(
    id = id,
    bin = bin,
    number = CardNumber(
        length = number.length,
        luhn = number.luhn
    ),
    scheme = scheme,
    type = type,
    brand = brand,
    prepaid = prepaid,
    country = country,
    bank = CardBank(
        name = bank.name,
        url = bank.url,
        phone = bank.phone,
        city = bank.city
    )
)

fun CardInfo.fromDomain() = CardInfoDbEntity(
    id = id,
    bin = bin,
    number = CardNumberTuple(
        length = number.length,
        luhn = number.luhn
    ),
    scheme = scheme,
    type = type,
    brand = brand,
    prepaid = prepaid,
    country = country,
    bank = CardBankTuple(
        name = bank.name,
        url = bank.url,
        phone = bank.phone,
        city = bank.city
    )
)

fun List<CardInfoDbEntity>.toDomain() = this.map {
    it.toDomain()
}