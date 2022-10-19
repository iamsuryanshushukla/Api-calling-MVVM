package com.example.viewmodelapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.viewmodelapi.model.Apps

class MainActivity : AppCompatActivity() {
    lateinit var recyclerAdapter: ItemRecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val recyclerview = findViewById<RecyclerView>(R.id.recycler_1)

        recyclerview.layoutManager = LinearLayoutManager(this)

        val decoration = DividerItemDecoration(this,DividerItemDecoration.VERTICAL)

        recyclerview.addItemDecoration(decoration)
        recyclerAdapter = ItemRecyclerAdapter()
        recyclerview.adapter = recyclerAdapter
        initViewModel()
    }

    private fun  initViewModel(){
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getRecyclereListObserver().observe(this, Observer<Apps> {
            if (it != null){
                recyclerAdapter.setUpdateData(it.feed.results)
            }else{
                Toast.makeText(this,"error is comming",Toast.LENGTH_LONG).show()
            }
        })
        viewModel.makeApiCall()

    }
}