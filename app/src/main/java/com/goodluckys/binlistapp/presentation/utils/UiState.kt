package com.goodluckys.binlistapp.presentation.utils

import com.goodluckys.binlistapp.domain.CardInfo

sealed class UiState {

    object Loading : UiState()
    class Success( val item : CardInfo) : UiState()
    object Complete : UiState()
    data class Error(val error:String) : UiState()

}