package com.goodluckys.binlistapp.domain

sealed class ResponseState {
    data class Successful(val item:CardInfo) : ResponseState()
    data class Error(val message:String) : ResponseState()
}