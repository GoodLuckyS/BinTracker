package com.goodluckys.binlistapp.presentation.screens.tabs

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.goodluckys.binlistapp.domain.CardInfo
import com.goodluckys.binlistapp.domain.ResponseState
import com.goodluckys.binlistapp.domain.usecases.AddCardInfoUseCase
import com.goodluckys.binlistapp.domain.usecases.RequestCardInfoUseCase
import com.goodluckys.binlistapp.presentation.utils.ERROR_VALIDATE_MESSAGE
import com.goodluckys.binlistapp.presentation.utils.UiState
import kotlinx.coroutines.launch
import javax.inject.Inject

class EnterBinViewModel @Inject constructor(
    private val requestCardInfoUseCase: RequestCardInfoUseCase,
    private val addCardInfoUseCase: AddCardInfoUseCase,
) : ViewModel() {

    private val _cardInfo = MutableLiveData<CardInfo>()
    val cardInfo: LiveData<CardInfo>
        get() = _cardInfo

    private val _errorInput = MutableLiveData<Boolean>()
    val errorInput: LiveData<Boolean>
        get() = _errorInput

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState>
        get() = _uiState

    fun getInfo(bin: String) {
        if (validate(bin)) {
            viewModelScope.launch {
                _uiState.value = UiState.Loading
                when (val responseState = requestCardInfoUseCase.requestCardInfo(bin)) {
                    is ResponseState.Successful -> {
                        val item = responseState.item
                        _uiState.value = UiState.Success(item)
                        addCardInfoUseCase.addCardInfo(item)
                    }
                    is ResponseState.Error -> {
                        _uiState.value = UiState.Error(responseState.message)
                    }

                }
            }
        } else _uiState.value = UiState.Error(ERROR_VALIDATE_MESSAGE)
    }

    fun setStateUI(uiState: UiState) {
        _uiState.value = uiState
    }

    private fun validate(it: String): Boolean {
        var result = true
        if (it.length < 6) {
            result = false
            _errorInput.value = true
        }
        return result
    }


}