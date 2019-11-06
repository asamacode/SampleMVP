package com.asama.luong.samplemvp.network

import com.asama.luong.samplemvp.data.PostData
import io.reactivex.Observable
import retrofit2.http.GET

interface INetworkApi {
    @GET(Endpoints.posts)
    fun getAllPosts() : Observable<List<PostData>>
}