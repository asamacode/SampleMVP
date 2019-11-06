package com.asama.luong.samplemvp.ui.posts

import android.app.Application
import com.asama.luong.samplemvp.ApplicationClass
import com.asama.luong.samplemvp.network.INetworkApi
import com.asama.luong.samplemvp.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.schedulers.IoScheduler
import javax.inject.Inject

class PostPresenterImpl(
    var postView: PostView,
    var applicationComponent: Application
) : PostPresenter, BasePresenter<PostView>(postView) {

    @Inject
    lateinit var mNetworkApi: INetworkApi

    init {
        (applicationComponent as ApplicationClass).applicationComponent.inject(this)
    }

    override fun getAllPosts() {
        postView.showLoading()
        var allPosts = mNetworkApi.getAllPosts()
        allPosts.subscribeOn(IoScheduler())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnTerminate { postView.hideLoading() }
            .subscribe(
                { result -> postView.showAllPosts(result) },
                { error -> postView.loadError(error) }
            )

    }
}