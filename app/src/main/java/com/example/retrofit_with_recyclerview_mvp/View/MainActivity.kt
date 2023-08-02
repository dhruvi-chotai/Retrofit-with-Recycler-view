package com.example.retrofit_with_recyclerview_mvp.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit_with_recyclerview.R
import com.example.retrofit_with_recyclerview_mvp.data.ApiClient
import com.example.retrofit_with_recyclerview_mvp.contract.contract
import com.example.retrofit_with_recyclerview_mvp.model.Post
import com.example.retrofit_with_recyclerview_mvp.presenter.presenter

// Create an activity MainActivity to fetch the data and display it using the RecyclerView:
class MainActivity : AppCompatActivity(), contract.view {

    private lateinit var postAdapter: PostAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var presenter: contract.presenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        /// Initialize the presenter
        presenter = presenter(this, ApiClient.apiService)
        presenter.fetchPosts()
    }

    override fun showPosts(posts: List<Post>) {
        postAdapter = PostAdapter(posts)
        recyclerView.adapter = postAdapter
    }

    override fun showError(message: String) {
        Log.e("MainActivity", "Error: $message")
    }


}



























/*  Certainly! Let's go through each line of code in the MainActivity class:

kotlin
Copy code
package com.example.retrofit_with_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
package com.example.retrofit_with_recyclerview:

This line declares the package name for the MainActivity class. It specifies the directory structure where the file is located.
import statements:

These lines import the necessary classes and dependencies required for the MainActivity class.
class MainActivity : AppCompatActivity() {:

This line declares the MainActivity class that extends the AppCompatActivity class, which provides the base class for activities.
kotlin
Copy code
private lateinit var postAdapter: PostAdapter
private lateinit var recyclerView: RecyclerView
These lines declare two properties: postAdapter of type PostAdapter and recyclerView of type RecyclerView. They will be used to set up and manipulate the RecyclerView in the activity.
kotlin
Copy code
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    recyclerView = findViewById(R.id.recyclerView)
    recyclerView.layoutManager = LinearLayoutManager(this)

    fetchData()
}
override fun onCreate(savedInstanceState: Bundle?):

This function is overridden from the AppCompatActivity class and is called when the activity is being created.
setContentView(R.layout.activity_main):

This line sets the content view of the activity to the layout resource R.layout.activity_main, which defines the UI elements for the activity.
recyclerView = findViewById(R.id.recyclerView):

This line finds the RecyclerView view with the ID recyclerView from the activity's layout and assigns it to the recyclerView property.
recyclerView.layoutManager = LinearLayoutManager(this):

This line sets the layout manager for the recyclerView to a LinearLayoutManager. It determines how the items in the RecyclerView will be laid out.
fetchData():

This line calls the fetchData() function, which is responsible for fetching the data from the API.
kotlin
Copy code
private fun fetchData() {
    val call = ApiClient.apiService.getPosts()
    call.enqueue(object : Callback<List<Post>> {
        override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
            if (response.isSuccessful) {
                val posts = response.body()
                postAdapter = posts?.let { PostAdapter(it) }!!
                recyclerView.adapter = postAdapter
            }
        }

        override fun onFailure(call: Call<List<Post>>, t: Throwable) {
            Log.e(TAG, "Error: ${t.message}")
        }
    })
}
private fun fetchData():

This is a private function that is responsible for fetching the data from the API using Retrofit.
val call = ApiClient.apiService.getPosts():

This line makes a network request to fetch the posts by calling the getPosts() function defined in the apiService instance of ApiClient.
call.enqueue(object : Callback<List<Post>>:

This line uses the enqueue() method to asynchronously enqueue the network request and handle the response using a callback.
override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {:

This function is an override of the onResponse() method from the Callback interface. It is called when the network request is successful and a response is received.
if (response.isSuccessful) {:

This condition checks if the response is successful, i.e., if the HTTP status code is in the range 200-299.
val posts = response.body():

This line retrieves the list of posts from the response body.
postAdapter = posts?.let { PostAdapter(it) }!!:

This line creates a new instance of the PostAdapter class using the retrieved posts list. The let function is used to handle the nullable posts value.
recyclerView.adapter = postAdapter:

This line sets the postAdapter as the adapter for the recyclerView.
override fun onFailure(call: Call<List<Post>>, t: Throwable) {:

This function is an override of the onFailure() method from the Callback interface. It is called when the network request fails.
Log.e(TAG, "Error: ${t.message}"):

This line logs an error message to the console using Log.e(). It includes the error message from the Throwable object t.
kotlin
Copy code
companion object {
    private const val TAG = "MainActivity"
}
companion object:

This keyword denotes a companion object in the class, which is similar to static members in Java.
private const val TAG = "MainActivity":

This line declares a constant TAG that will be used for logging purposes.
In summary, the MainActivity class is responsible for setting up the RecyclerView, fetching the data from the API using Retrofit, and binding the data to the RecyclerView using the PostAdapter. The fetched data is displayed in the RecyclerView, and any errors are logged to the console.




  */
