package com.example.retrofit_with_recyclerview_mvp.presenter

import com.example.retrofit_with_recyclerview_mvp.data.ApiService
import com.example.retrofit_with_recyclerview_mvp.contract.contract
import com.example.retrofit_with_recyclerview_mvp.model.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class presenter(private val view: contract.view, private val apiService: ApiService):
contract.presenter {
    override fun fetchPosts() {
        apiService.getPosts().enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                      val posts = response.body()
                    posts?.let { view.showPosts(it) }
                } else {
                    view.showError("Failed to fetch posts")
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                view.showError(t.message?:"Unkown Error Occured")
            }
        })

    }
}