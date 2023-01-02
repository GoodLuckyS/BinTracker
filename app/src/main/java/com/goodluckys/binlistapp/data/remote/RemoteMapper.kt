package com.goodluckys.binlistapp.data.remote

import com.goodluckys.binlistapp.data.UNDEF_ID
import com.goodluckys.binlistapp.data.remote.dto.CardBankDTO
import com.goodluckys.binlistapp.data.remote.dto.CardCountryDTO
import com.goodluckys.binlistapp.data.remote.dto.CardInfoDTO
import com.goodluckys.binlistapp.data.remote.dto.CardNumberDTO
import com.goodluckys.binlistapp.domain.CardInfo
import com.goodluckys.binlistapp.domain.entity.CardBank
import com.goodluckys.binlistapp.domain.entity.CardNumber
import com.goodluckys.binlistapp.mapToString


fun CardInfoDTO?.toDomain(bin: String): CardInfo = CardInfo(
    id = UNDEF_ID,
    bin = bin,
    number = this?.number.toDomain(),
    scheme = this?.scheme.mapToString(),
    type = this?.type.mapToString(),
    brand = this?.brand.mapToString(),
    prepaid = this?.prepaid.mapToString(),
    country = this?.country.toDomain(),
    bank = this?.bank.toDomain()
)

fun CardBankDTO?.toDomain(): CardBank = CardBank(
    name = this?.name.mapToString(),
    url = this?.url.mapToString(),
    phone = this?.phone.mapToString(),
    city = this?.city.mapToString()
)

fun CardCountryDTO?.toDomain(): String {
    return (this?.emoji ?: "") +
            this?.name.mapToString() + "," +
            this?.alpha2.mapToString() + "\n" +
            "lat:" + this?.latitude.mapToString() + " " +
            "lon:" + this?.longitude.mapToString() + "," +
            "Numeric:" + this?.numeric.mapToString()
}


fun CardNumberDTO?.toDomain(): CardNumber = CardNumber(
    length = this?.length.mapToString(),
    luhn = this?.luhn.mapToString()
)





