package com.asama.luong.samplemvp.ui.login

import android.app.Application
import com.asama.luong.samplemvp.ApplicationClass
import com.asama.luong.samplemvp.ui.base.BasePresenter

class LoginPresenterImpl(
    var loginViewInit : LoginView,
    var applicationComponent: Application
    ) : LoginPresenter, BasePresenter<LoginView>(loginViewInit) {

    init {
        (applicationComponent as ApplicationClass).applicationComponent.inject(this)
    }

    override fun performLogin(userName: String, userPassword: String) {
        if (userName == "asama") {
            loginViewInit.navigateToHome()
        }
    }

    override fun validateUser(userName: String, userPassword: String) {
        if (userPassword == "")
            loginViewInit.onPasswordError()
    }
}