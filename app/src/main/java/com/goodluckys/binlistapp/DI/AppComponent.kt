package com.goodluckys.binlistapp.DI

import android.app.Application
import com.goodluckys.binlistapp.DI.modules.AppModule
import com.goodluckys.binlistapp.presentation.screens.tabs.EnterBinFragment
import com.goodluckys.binlistapp.presentation.screens.tabs.HistoryFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(historyFragment: HistoryFragment)
    fun inject(enterBinFragment: EnterBinFragment)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application,
        ): AppComponent
    }

}