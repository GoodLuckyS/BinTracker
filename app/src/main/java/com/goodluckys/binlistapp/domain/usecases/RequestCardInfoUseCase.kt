package com.goodluckys.binlistapp.domain.usecases

import com.goodluckys.binlistapp.domain.RemoteRepository
import javax.inject.Inject

class RequestCardInfoUseCase@Inject constructor(private val remoteRepository: RemoteRepository) {
    suspend fun requestCardInfo(bin:String) = remoteRepository.requestCardInfo(bin)
}