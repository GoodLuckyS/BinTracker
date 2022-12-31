package com.goodluckys.binlistapp.domain.usecases

import com.goodluckys.binlistapp.domain.HistoryRepository
import javax.inject.Inject

class GetHistoryListUseCase@Inject constructor(private val historyRepository: HistoryRepository) {
    fun getHistoryList() = historyRepository.getHistoryList()
}