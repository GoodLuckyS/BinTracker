package com.goodluckys.binlistapp.DI.modules

import android.app.Application
import com.goodluckys.binlistapp.data.remote.RemoteRepositoryImpl
import com.goodluckys.binlistapp.data.remote.service.RemoteService
import com.goodluckys.binlistapp.data.room.AppDatabase
import com.goodluckys.binlistapp.data.room.CardInfoDao
import com.goodluckys.binlistapp.data.room.HistoryRepositoryImpl
import com.goodluckys.binlistapp.domain.HistoryRepository
import com.goodluckys.binlistapp.domain.RemoteRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [
    ViewModelModule::class,
    LocalModule::class,
    ApiModule::class
])
class AppModule {}

@Module
interface ApiModule {
    @Singleton
    @Binds
    fun bindRemoteRepository(impl: RemoteRepositoryImpl): RemoteRepository
    companion object {
        @Singleton
        @Provides
        fun provideService() = RemoteService().configureRetrofit()
    }

}

@Module
interface LocalModule {
    @Singleton
    @Binds
    fun bindHistoryRepository(impl: HistoryRepositoryImpl): HistoryRepository

    companion object {
        @Singleton
        @Provides
        fun provideShopListDao(application: Application) : CardInfoDao {
            return AppDatabase.getDatabase(application).cardInfoDao()
        }
    }
}