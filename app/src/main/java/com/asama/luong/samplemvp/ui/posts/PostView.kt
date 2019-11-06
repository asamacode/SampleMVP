package com.asama.luong.samplemvp.ui.posts

import com.asama.luong.samplemvp.data.PostData
import com.asama.luong.samplemvp.ui.base.IView

interface PostView : IView {

    fun showAllPosts(postList: List<PostData>)
}