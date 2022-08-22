package com.example.android.quotes.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.quotes.adapter.NextAdapter
import com.example.android.quotes.api.NewService
import com.example.android.quotes.api.RetrofitHelper
import com.example.android.quotes.databinding.ActivityList2Binding
import com.example.android.quotes.factory.NextViewModelFactory
import com.example.android.quotes.repository.NextRepository
import com.example.android.quotes.viewmodel.NextViewModel

class NextActivity: AppCompatActivity() {

    private lateinit var binding: ActivityList2Binding
    lateinit var viewModel: NextViewModel
    private val TAG="New"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityList2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {
            val intent= Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        val newAdapter= NextAdapter(this)
        binding.recvList2.layoutManager= LinearLayoutManager(this)
        binding.recvList2.adapter=newAdapter

        val retrofitService = RetrofitHelper.getInstance().create(NewService::class.java)

        viewModel =
            ViewModelProvider(this, NextViewModelFactory(NextRepository(retrofitService))).get(
                NextViewModel::class.java)
        binding.recvList2.adapter =newAdapter

        viewModel.userlist.observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            newAdapter.put_data(it)
        })
        viewModel.errorMessage.observe(this, Observer {
        })
        viewModel.lineardata()
    }
}