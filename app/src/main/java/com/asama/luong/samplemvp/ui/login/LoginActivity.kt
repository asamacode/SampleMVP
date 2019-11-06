package com.asama.luong.samplemvp.ui.login

import android.os.Bundle
import android.widget.Toast
import com.asama.luong.samplemvp.R
import com.asama.luong.samplemvp.ui.base.BaseActivity
import com.asama.luong.samplemvp.ui.posts.PostActivity

class LoginActivity : BaseActivity(), LoginView {

    var loginPresenter: LoginPresenterImpl? = null

    fun getPresenter() : LoginPresenterImpl? {
        loginPresenter = LoginPresenterImpl(this, application)
        return loginPresenter
    }

    override fun setLayout(): Int {
        return R.layout.activity_login
    }

    override fun init(savedInstanceState: Bundle?) {
        getPresenter()?.let {
            it.performLogin("asama","")
        }
    }

    override fun onStartScreen() {
        
    }

    override fun stopScreen() {
        loginPresenter?.let {
            loginPresenter!!.unbindView()
            loginPresenter = null
        }
    }

    override fun navigateToHome() {
        Toast.makeText(this, "Hello MVP", Toast.LENGTH_SHORT).show()
        var intent = PostActivity.getStartIntent(this)
        startActivity(intent)
        finish()
    }

    override fun onBackPress() {

    }

    override fun onPasswordError() {
        Toast.makeText(this, "Password error!", Toast.LENGTH_SHORT).show()
    }

}
