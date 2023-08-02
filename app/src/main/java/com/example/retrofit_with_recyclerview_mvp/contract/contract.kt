package com.example.retrofit_with_recyclerview_mvp.contract
import com.example.retrofit_with_recyclerview_mvp.model.Post

interface contract {
    interface view {
        fun showPosts(posts: List<Post>)
        fun showError(message: String)
    }

    interface model {
        fun getPosts(callback: Callback)
        interface Callback {
            fun onSuccess(posts: List<Post>)
            fun onFailure(error: String)
            
        }

    }

    interface presenter {
            fun fetchPosts()
    }
}