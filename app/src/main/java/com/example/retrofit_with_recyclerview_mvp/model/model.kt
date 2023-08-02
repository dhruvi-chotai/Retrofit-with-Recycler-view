package com.example.retrofit_with_recyclerview_mvp.model

import com.example.retrofit_with_recyclerview_mvp.data.ApiService
import com.example.retrofit_with_recyclerview_mvp.contract.contract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class model(private val apiService: ApiService): contract.model {

    override fun getPosts(callback: contract.model.Callback) {
        apiService.getPosts().enqueue(object :Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful){
                    val posts = response.body()
                    posts?.let { callback.onSuccess(it) }
                } else {
                    callback.onFailure("Failed to fetch posts")
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                callback.onFailure(t.message ?: "Unknown Error Occured")
            }
        })

    }
}