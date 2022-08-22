package com.example.android.quotes
import com.example.android.quotes.api.NewService

class NewRepository constructor(private val retrofitService: NewService) {

    fun getData() = retrofitService.getdata()
}