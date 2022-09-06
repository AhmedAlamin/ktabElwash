package com.example.ktabelwash

import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    @GET("posts/{id}")
    fun getPost(@Path("id") id:Int): Call<Post>

    @POST("posts")
    fun storePost(@Body body :HashMap<Any,Any> ) :Call<Post>
}