package com.asama.luong.samplemvp

import android.app.Application
import com.asama.luong.samplemvp.di.component.ApplicationComponent
import com.asama.luong.samplemvp.di.component.DaggerApplicationComponent
import com.asama.luong.samplemvp.di.module.NetModule

open class ApplicationClass : Application() {

   public lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()


        applicationComponent = DaggerApplicationComponent.builder()
            .netModule(NetModule())
            .build()

        applicationComponent.inject(this)
    }
}
