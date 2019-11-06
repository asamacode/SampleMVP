package com.asama.luong.samplemvp.di.component

import com.asama.luong.samplemvp.ApplicationClass
import com.asama.luong.samplemvp.di.module.AppModule
import com.asama.luong.samplemvp.di.module.NetModule
import com.asama.luong.samplemvp.ui.login.LoginPresenterImpl
import com.asama.luong.samplemvp.ui.posts.PostPresenterImpl
import dagger.Component

@Component(modules = [NetModule::class, AppModule::class])
interface ApplicationComponent {

    fun inject(mewApplication: ApplicationClass)
    fun inject(mLoginPresenterImpl: LoginPresenterImpl)
    fun inject(mPostPresenterImpl: PostPresenterImpl)
}