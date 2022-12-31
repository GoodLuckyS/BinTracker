package com.goodluckys.binlistapp.domain.usecases

import com.goodluckys.binlistapp.domain.CardInfo
import com.goodluckys.binlistapp.domain.HistoryRepository
import javax.inject.Inject

class AddCardInfoUseCase @Inject constructor(private val historyRepository: HistoryRepository) {
    suspend fun addCardInfo(item:CardInfo) = historyRepository.addCardInfo(item)
}