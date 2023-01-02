package com.goodluckys.binlistapp.presentation.screens.tabs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.goodluckys.binlistapp.domain.CardInfo
import com.goodluckys.binlistapp.domain.usecases.DeleteCardInfoUseCase
import com.goodluckys.binlistapp.domain.usecases.GetHistoryListUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class HistoryViewModel @Inject constructor(
    getHistoryListUseCase: GetHistoryListUseCase,
    private val deleteCardInfoUseCase: DeleteCardInfoUseCase,
) : ViewModel() {

    val historyList = getHistoryListUseCase.getHistoryList()

    fun deleteCardInfo(item: CardInfo) {
        viewModelScope.launch {
            deleteCardInfoUseCase.deleteCardInfo(item)
        }
    }

}