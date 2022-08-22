package com.example.android.quotes.api

import com.example.android.quotes.models.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET

interface NewService{
    @GET("users")
    fun getdata() : Call<List<User>>

    @GET("users")
    fun listdata():Call<List<User>>


    @GET("")
    fun fetchdata():Call<List<User>>
}