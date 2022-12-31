package com.goodluckys.binlistapp.domain

import androidx.lifecycle.LiveData
import com.goodluckys.binlistapp.data.remote.dto.CardInfoDTO

interface HistoryRepository {

    fun getHistoryList(): LiveData<List<CardInfo>>

    suspend fun getCardInfo(itemId:Int) : CardInfo

    suspend fun addCardInfo(item: CardInfo)

    suspend fun deleteCardInfo(item: CardInfo)

}