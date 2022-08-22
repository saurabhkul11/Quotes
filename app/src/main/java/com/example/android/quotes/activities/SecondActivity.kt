package com.example.android.quotes.activities

import android.content.ContentValues
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.quotes.adapter.SecondAdapter
import com.example.android.quotes.api.NewService
import com.example.android.quotes.api.RetrofitHelper
import com.example.android.quotes.databinding.ActivityList3Binding
import com.example.android.quotes.factory.SecondViewModelFactory
import com.example.android.quotes.repository.SecondRepository
import com.example.android.quotes.viewmodel.SecondViewModel

class SecondActivity: AppCompatActivity() {

    lateinit var viewModel: SecondViewModel
    lateinit var binding: ActivityList3Binding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        binding= ActivityList3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter2= SecondAdapter(this)
        binding.recvList3.layoutManager= LinearLayoutManager(this)
        binding.recvList3.adapter=adapter2

        val apiservice= RetrofitHelper.getInstance().create(NewService::class.java)

        viewModel=
            ViewModelProvider(this, SecondViewModelFactory(SecondRepository(apiservice))).get(
                SecondViewModel::class.java)
        binding.recvList3.adapter =adapter2

        viewModel.list.observe(this,{
            Log.d(ContentValues.TAG, "onCreate: $it")
            adapter2.fdata(it)
        })

        viewModel.er.observe(this,{

        })

        viewModel.fetch()

    }


}