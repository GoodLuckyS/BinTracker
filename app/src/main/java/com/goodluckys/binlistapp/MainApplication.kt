package com.goodluckys.binlistapp

import android.app.Application
import com.goodluckys.binlistapp.DI.DaggerAppComponent

class MainApplication : Application() {

    val appComponent by lazy {
        DaggerAppComponent.factory().create(this)
    }
}
