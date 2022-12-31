package com.goodluckys.binlistapp.data.remote.service

import com.goodluckys.binlistapp.data.remote.dto.CardInfoDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CardService {

    @GET("/{bin}")
    suspend fun getCardInfo(@Path("bin") bin:String): Response<CardInfoDTO>

}