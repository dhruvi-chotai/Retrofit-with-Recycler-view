package com.example.retrofit_with_recyclerview_mvp.data
// Create an interface ApiService to define the API endpoints:
import com.example.retrofit_with_recyclerview_mvp.model.Post
import retrofit2.Call
import retrofit2.http.GET


interface ApiService {
    @GET("posts")
    fun getPosts(): Call<List<Post>>
}


//The ApiClient and ApiService classes are placed in the data package because
// they are responsible
// for
  //  handling the network-related operations and data retrieval from the API.

























/*  package com.example.retrofit_with_recyclerview:
        ◦ This line declares the package name for the ApiService interface. It specifies the directory structure where the file is located.
    • import retrofit2.Call and import retrofit2.http.GET:
        ◦ These lines import the necessary classes and annotations from the Retrofit library that will be used to define the API endpoints.
    • interface ApiService:
        ◦ This line declares an interface named ApiService. Interfaces in Kotlin define a contract that specifies the available methods and their signatures.
    • @GET("posts"):
        ◦ This line is an annotation placed on the getPosts() method, indicating that it is an HTTP GET request to the "posts" endpoint. The annotation specifies the relative URL endpoint path.
    • fun getPosts(): Call<List<Post>>:
        ◦ This line declares a method named getPosts() with no arguments. It returns a Call object that represents the network request for retrieving a list of Post objects. The List<Post> specifies the response type expected from the API.
In summary, the ApiService interface defines the API endpoints that can be called using Retrofit. It specifies the HTTP method, relative URL, and the expected response type. In this case, the getPosts() method represents an HTTP GET request to the "posts" endpoint, and it expects a response of type List<Post>.  */