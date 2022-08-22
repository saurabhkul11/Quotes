package com.example.android.quotes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.quotes.models.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewViewModel constructor(private val repository: NewRepository)  : ViewModel() {

    val userlist = MutableLiveData<List<User>>()
    val errorMessage = MutableLiveData<String>()

    fun getAlldata() {
        val result = repository.getData()
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
