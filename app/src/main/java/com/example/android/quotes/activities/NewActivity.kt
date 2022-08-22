package com.example.android.quotes.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.android.quotes.NewAdapter
import com.example.android.quotes.NewRepository
import com.example.android.quotes.NewViewModel
import com.example.android.quotes.api.NewService
import com.example.android.quotes.api.RetrofitHelper
import com.example.android.quotes.databinding.ActivityListBinding
import com.example.android.quotes.factory.NewViewModelFactory

class NewActivity: AppCompatActivity() {

    private lateinit var binding: ActivityListBinding
    lateinit var viewModel: NewViewModel
    private val TAG="New"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnListProceed.setOnClickListener {
            val intent= Intent(this, NextActivity::class.java)
            startActivity(intent)
        }

        val newAdapter= NewAdapter(this)
        binding.recvList.layoutManager= GridLayoutManager(this,2)
        binding.recvList.adapter=newAdapter

        val retrofitService = RetrofitHelper.getInstance().create(NewService::class.java)

        viewModel =
            ViewModelProvider(this, NewViewModelFactory(NewRepository(retrofitService))).get(
                NewViewModel::class.java)
        binding.recvList.adapter =newAdapter

        viewModel.userlist.observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            newAdapter.give_data(it)
        })
        viewModel.errorMessage.observe(this, Observer {
        })
        viewModel.getAlldata()
    }
}

