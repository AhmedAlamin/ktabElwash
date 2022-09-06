package com.example.ktabelwash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var hashmap = HashMap<Any,Any>()
        hashmap.put("title","this is the title")
        hashmap.put("body","this is the body")
        hashmap.put("userId",1)


        var retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        var apiInterface = retrofit.create(ApiInterface::class.java)

        var call = apiInterface.storePost(hashmap)

        call.enqueue(object :Callback<Post>{
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                theText.text = response.body()?.userId.toString()
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                theText.text = t.message.toString()
            }
        })




    }
}