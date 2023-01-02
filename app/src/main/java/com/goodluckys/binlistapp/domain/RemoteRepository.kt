package com.goodluckys.binlistapp.domain


interface RemoteRepository {

    suspend fun requestCardInfo(bin: String): ResponseState

}