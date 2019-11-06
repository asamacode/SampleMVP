package com.asama.luong.samplemvp.ui.login

interface LoginPresenter {

    fun performLogin(userName: String, userPassword: String)

    fun validateUser(userName: String, userPassword: String)

}