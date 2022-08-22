package com.example.android.quotes.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.quotes.models.User
import com.example.android.quotes.repository.NextRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NextViewModel constructor(private val repository: NextRepository):ViewModel() {

    val userlist = MutableLiveData<List<User>>()
    val errorMessage = MutableLiveData<String>()

    fun lineardata(){
        val result = repository.lin_data()
        result.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                userlist.postValue(response.body())
            }
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }



}