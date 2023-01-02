package com.goodluckys.binlistapp.data.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.goodluckys.binlistapp.data.room.entity.CardInfoDbEntity

@Dao
interface CardInfoDao {

    @Query("SELECT * FROM card_info")
    fun getHistoryList(): LiveData<List<CardInfoDbEntity>>

    @Insert
    suspend fun addCardInfo(cardInfo: CardInfoDbEntity)

    @Delete
    suspend fun deleteCardInfo(cardInfo: CardInfoDbEntity)

}