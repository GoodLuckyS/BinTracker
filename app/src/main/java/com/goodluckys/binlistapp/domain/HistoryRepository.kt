package com.goodluckys.binlistapp.domain

import androidx.lifecycle.LiveData

interface HistoryRepository {

    fun getHistoryList(): LiveData<List<CardInfo>>

    suspend fun addCardInfo(item: CardInfo)

    suspend fun deleteCardInfo(item: CardInfo)

}