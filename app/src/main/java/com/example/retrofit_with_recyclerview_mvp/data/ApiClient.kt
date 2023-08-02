package com.example.retrofit_with_recyclerview_mvp.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
// Create a class ApiClient to initialize Retrofit and provide an instance of ApiService:
object ApiClient {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    val apiService: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(ApiService::class.java)
    }
}

//The ApiClient and ApiService classes are placed in the data package because
// they are responsible
// for handling the network-related operations and data retrieval from the API.



























/*         ◦ These lines import the necessary classes from the Retrofit library that will be used to set up the network requests.
    • object ApiClient:
        ◦ This line declares an object class named ApiClient. object is a singleton in Kotlin, meaning it represents a single instance of the class that is globally accessible.
    • private const val BASE_URL = "https://jsonplaceholder.typicode.com/":
        ◦ This line declares a constant BASE_URL that represents the base URL of the API endpoint we want to communicate with. In this case, it's the JSONPlaceholder API.
    • val apiService: ApiService by lazy { ... }:
        ◦ This line declares a val property named apiService of type ApiService. It uses the by lazy delegate to lazily initialize the value. The value will be initialized the first time it is accessed and then cached for subsequent accesses.
    • val retrofit = Retrofit.Builder() ... .build():
        ◦ This block of code initializes a Retrofit object by using the Retrofit.Builder class. It sets the base URL, adds a GsonConverterFactory to convert JSON responses to Kotlin objects using Gson, and builds the Retrofit object.
    • retrofit.create(ApiService::class.java):
        ◦ This line creates an instance of the ApiService interface using the Retrofit object. It uses the .create() method and passes the ApiService::class.java as the service interface class to generate an implementation of the interface.
In summary, the ApiClient object provides a single instance of the ApiService interface that can be used to make network requests using Retrofit. The BASE_URL specifies the base URL for the API, and the apiService property provides an instance of the ApiService interface by lazily initializing a Retrofit object. */
