package com.example.viewmodelapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newapi.ApiModel
import com.example.viewmodelapi.adapters.ItemRecyclerAdapter
import com.example.viewmodelapi.adapters.RecyclerViewAdapter
import com.example.viewmodelapi.model.firs_api_model.Apps
import com.example.viewmodelapi.viewmodels.MainActivityViewModel
import com.example.viewmodelapi.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var recyclerAdapter: ItemRecyclerAdapter
    lateinit var recyclerAdapter2: RecyclerViewAdapter
    lateinit var btn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val recyclerview = findViewById<RecyclerView>(R.id.recycler_1)
//        val recyclerview2 = findViewById<RecyclerView>(R.id.recylvvein)
        btn = findViewById(R.id.btn)

        recyclerview.layoutManager = LinearLayoutManager(this)

//        recyclerview2.layoutManager = LinearLayoutManager(this)
//
        recyclerAdapter2 = RecyclerViewAdapter()
//        recyclerview2.adapter = recyclerAdapter2

        val decoration = DividerItemDecoration(this,DividerItemDecoration.VERTICAL)


        recyclerview.addItemDecoration(decoration)
        recyclerAdapter = ItemRecyclerAdapter()
        recyclerview.adapter = recyclerAdapter
        initViewModel()

//        initViewModel2()
        newScreen()
    }

    private fun  initViewModel(){
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getRecyclereList2Observer().observe(this, Observer<Apps> {
            if (it != null){
                recyclerAdapter.setUpdateData(it.feed.results)
            }else{
                Toast.makeText(this,"error is comming",Toast.LENGTH_LONG).show()
            }
        })

        viewModel.makeApiCall()

    }


//    fun initViewModel2(){
//        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
//        viewModel.getRecyclereListObserver().observe(this, Observer<ApiModel> {
//            if (it != null){
//                recyclerAdapter2.setUpdateData(items = it.entries)
//            }else{
//                Toast.makeText(this,"Error os coming", Toast.LENGTH_LONG).show()
//            }
//        })
//        viewModel.makeApiCall()
//    }
    private fun newScreen(){

        btn.setOnClickListener {
            val intent =Intent(this,SecondApi::class.java)
            startActivity(intent)
        }
    }
}