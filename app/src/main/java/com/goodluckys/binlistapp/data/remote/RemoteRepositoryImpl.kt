package com.goodluckys.binlistapp.data.remote

import com.goodluckys.binlistapp.data.remote.service.CardService
import com.goodluckys.binlistapp.domain.RemoteRepository
import com.goodluckys.binlistapp.domain.ResponseState
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(private val cardService: CardService) :
    RemoteRepository {

    override suspend fun requestCardInfo(bin: String): ResponseState {
        val response = cardService.getCardInfo(bin)
        return if (response.isSuccessful) {
            ResponseState.Successful(response.body().toDomain(bin))
        } else ResponseState.Error(error + " " + response.code().toString())
    }

    companion object {
        const val error = "Error,check BIN/IIN"
    }
}