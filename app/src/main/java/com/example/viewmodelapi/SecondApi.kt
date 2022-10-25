package com.example.viewmodelapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newapi.ApiModel
import com.example.viewmodelapi.adapters.RecyclerViewAdapter
import com.example.viewmodelapi.viewmodels.MainActivityViewModel

class SecondApi : AppCompatActivity() {
    lateinit var recyclerAdapter: RecyclerViewAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_api)

        val recyclerView=findViewById<RecyclerView>(R.id.recylvvein)


        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerAdapter = RecyclerViewAdapter()
        recyclerView.adapter = recyclerAdapter

//        val bundle = this.intent.getBundleExtra("value")

        initViewModel()
    }
    fun initViewModel(){
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getRecyclereListObserver().observe(this, Observer<ApiModel> {
            if (it != null){
                recyclerAdapter.setUpdateData(items = it.entries)
            }else{
                Toast.makeText(this,"Error os coming", Toast.LENGTH_LONG).show()
            }
        })
        viewModel.makeApiCall()
    }
}