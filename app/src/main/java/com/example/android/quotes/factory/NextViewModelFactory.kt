package com.example.android.quotes.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.quotes.NewViewModel
import com.example.android.quotes.repository.NextRepository
import com.example.android.quotes.viewmodel.NextViewModel

class NextViewModelFactory(private val repository: NextRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NextViewModel::class.java)) {
            return NextViewModel(repository) as T
        }
        throw IllegalArgumentException("UnknownViewModel")
    }
}