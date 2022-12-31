package com.goodluckys.binlistapp.domain.usecases

import com.goodluckys.binlistapp.domain.CardInfo
import com.goodluckys.binlistapp.domain.HistoryRepository
import javax.inject.Inject

class DeleteCardInfoUseCase @Inject constructor(private val historyRepository: HistoryRepository) {
    suspend fun deleteCardInfo(item:CardInfo) = historyRepository.deleteCardInfo(item)
}