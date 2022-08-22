package com.example.android.quotes.repository

import com.example.android.quotes.api.NewService

class NextRepository constructor(private val retrofitService: NewService) {

    fun lin_data() = retrofitService.listdata()
}