package com.example.android.quotes.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.quotes.NewRepository
import com.example.android.quotes.NewViewModel

class NewViewModelFactory(private val repository: NewRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewViewModel::class.java)) {
            return NewViewModel(repository) as T
        }
        throw IllegalArgumentException("UnknownViewModel")
    }
}