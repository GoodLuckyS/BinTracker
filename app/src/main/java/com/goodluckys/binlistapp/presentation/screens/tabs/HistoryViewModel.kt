package com.goodluckys.binlistapp.presentation.screens.tabs

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.goodluckys.binlistapp.domain.CardInfo
import com.goodluckys.binlistapp.domain.usecases.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class HistoryViewModel@Inject constructor(
    getHistoryListUseCase: GetHistoryListUseCase,
    private val getCardInfoUseCase: GetCardInfoUseCase,
    private val deleteCardInfoUseCase: DeleteCardInfoUseCase
) : ViewModel() {

    private val _cardInfo = MutableLiveData<CardInfo>()
    val cardInfo: LiveData<CardInfo>
        get() = _cardInfo

    val historyList = getHistoryListUseCase.getHistoryList()

    fun getCardInfo(id:Int) {
        viewModelScope.launch {
            val item = getCardInfoUseCase.getCardInfo(id)
            _cardInfo.value = item
        }
    }

    fun deleteCardInfo(item:CardInfo){
        viewModelScope.launch {
            deleteCardInfoUseCase.deleteCardInfo(item)
        }
    }



}