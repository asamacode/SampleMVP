package com.asama.luong.samplemvp.ui.base

import android.app.ProgressDialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.asama.luong.samplemvp.R

abstract class BaseActivity : AppCompatActivity(), IView {

    protected var mProgressDialog: ProgressDialog? = null

    @LayoutRes
    abstract fun setLayout():Int
    abstract fun init(savedInstanceState: Bundle?)
    abstract fun onStartScreen()
    abstract fun stopScreen()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayout())
        initialzeProgressDialoge()
        init(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        System.gc()
        System.runFinalization()

    }

    override fun onStart() {
        super.onStart()
        onStartScreen()
    }
    override fun onStop() {
        super.onStop()
        stopScreen()
    }

    override fun hideLoading() {
        dismissProgress()
    }

    override fun loadError(e: Throwable) {
        showHttpError(e)
    }

    override fun loadError(msg: String) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
        showProgress(R.string.loading, null)
    }

    fun initialzeProgressDialoge() {
        if (mProgressDialog == null) {
            mProgressDialog = ProgressDialog(this)
            mProgressDialog!!.isIndeterminate = true
            mProgressDialog!!.setCancelable(false)
        }
    }


    fun showProgress(
        msgResId: Int,
        keyListener: DialogInterface.OnKeyListener?
    ) {
        if (isFinishing)
            return
        if (mProgressDialog!!.isShowing) {
            return
        }
        if (msgResId != 0) {
            mProgressDialog?.setMessage(resources.getString(msgResId))
        }
        if (keyListener != null) {
            mProgressDialog?.setOnKeyListener(keyListener)
        } else {
            mProgressDialog?.setCancelable(false)
        }
        mProgressDialog?.show()
    }


    fun setCancelableProgress(isCancel: Boolean) {
        if (mProgressDialog != null) {
            mProgressDialog?.setCancelable(true)
        }
    }

    /**
     * cancel progress dialog.
     */
    fun dismissProgress() {
        if (mProgressDialog != null && mProgressDialog!!.isShowing) {
            mProgressDialog?.dismiss()
        }

    }

    protected fun showHttpError(e: Throwable) {
        loadError(e.localizedMessage)
    }

}