package com.goodluckys.binlistapp.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.goodluckys.binlistapp.data.room.entity.CardInfoDbEntity

@Database(
    version = 1,
    entities = [
        CardInfoDbEntity::class
    ]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun cardInfoDao(): CardInfoDao

    companion object {

        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "card_info"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}