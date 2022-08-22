package com.example.android.quotes.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.quotes.models.User
import com.example.android.quotes.repository.SecondRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SecondViewModel constructor(private val repository: SecondRepository):ViewModel() {

    val list=MutableLiveData<List<User>>()
    val er=MutableLiveData<String>()

    fun fetch(){
        val res=repository.fetch_data()
        res.enqueue(object :Callback<List<User>>{
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                list.postValue(response.body())
            }
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                er.postValue(t.message)
            }
        }
        )

    }
}