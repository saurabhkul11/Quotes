package com.example.android.quotes.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.quotes.repository.SecondRepository
import com.example.android.quotes.viewmodel.SecondViewModel

class SecondViewModelFactory(private val repository: SecondRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SecondViewModel::class.java)) {
            return SecondViewModel(repository) as T
        }
        throw IllegalArgumentException("UnknownViewModel")
    }
}