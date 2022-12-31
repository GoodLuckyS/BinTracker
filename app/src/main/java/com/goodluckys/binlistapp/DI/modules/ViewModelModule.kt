package com.goodluckys.binlistapp.DI.modules

import androidx.lifecycle.ViewModel
import com.goodluckys.binlistapp.DI.ViewModelKey
import com.goodluckys.binlistapp.presentation.screens.tabs.EnterBinViewModel
import com.goodluckys.binlistapp.presentation.screens.tabs.HistoryViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(EnterBinViewModel::class)
    fun provideEnterBinViewModel(enterBinViewModel: EnterBinViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HistoryViewModel::class)
    fun provideHistoryViewModel(historyViewModel: HistoryViewModel) : ViewModel



}