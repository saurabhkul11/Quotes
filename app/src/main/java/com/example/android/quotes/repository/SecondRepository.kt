package com.example.android.quotes.repository

import com.example.android.quotes.api.NewService

class SecondRepository constructor(private val retrofitService: NewService) {

    fun fetch_data()=retrofitService.fetchdata()

}