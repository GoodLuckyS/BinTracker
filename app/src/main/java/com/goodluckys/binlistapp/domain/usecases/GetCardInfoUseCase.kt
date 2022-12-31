package com.goodluckys.binlistapp.domain.usecases

import com.goodluckys.binlistapp.domain.HistoryRepository
import javax.inject.Inject

class GetCardInfoUseCase @Inject constructor(private val historyRepository: HistoryRepository) {
    suspend fun getCardInfo(itemId:Int) = historyRepository.getCardInfo(itemId)
}