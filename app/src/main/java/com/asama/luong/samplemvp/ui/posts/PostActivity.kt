package com.asama.luong.samplemvp.ui.posts

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.asama.luong.samplemvp.R
import com.asama.luong.samplemvp.data.PostData
import com.asama.luong.samplemvp.ui.adapters.PostItemAdapter
import com.asama.luong.samplemvp.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_post.*


class PostActivity : BaseActivity(), PostView {


    var postPresenter : PostPresenterImpl? = null

    fun getPresenter(): PostPresenterImpl? {
        postPresenter = PostPresenterImpl(this, application)
        return postPresenter
    }

    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, PostActivity::class.java)
        }
    }

    override fun setLayout(): Int {
        return R.layout.activity_post
    }

    override fun init(savedInstanceState: Bundle?) {
        getPresenter()?.let {
            it.getAllPosts()
        }
    }

    override fun onStartScreen() {

    }

    override fun stopScreen() {
        postPresenter?.let {
            postPresenter!!.unbindView()
            postPresenter = null
        }
    }

    override fun showAllPosts(postList: List<PostData>) {
        rv_post_list.layoutManager = LinearLayoutManager(this)
        rv_post_list.adapter = PostItemAdapter(postList, this)
    }

}
