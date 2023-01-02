package com.goodluckys.binlistapp.data.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.goodluckys.binlistapp.domain.CardInfo
import com.goodluckys.binlistapp.domain.HistoryRepository
import javax.inject.Inject

class HistoryRepositoryImpl @Inject constructor(
    private val cardInfoDao: CardInfoDao,
) : HistoryRepository {
    override fun getHistoryList(): LiveData<List<CardInfo>> =
        MediatorLiveData<List<CardInfo>>().apply {
            addSource(cardInfoDao.getHistoryList()) {
                value = it.toDomain()
            }
        }

    override suspend fun addCardInfo(item: CardInfo) {
        val itemDB = item.fromDomain()
        cardInfoDao.addCardInfo(itemDB)
    }

    override suspend fun deleteCardInfo(item: CardInfo) {
        val itemDB = item.fromDomain()
        cardInfoDao.deleteCardInfo(itemDB)
    }

}