package com.example.viewmodelapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.databinding.DataBindingUtil
import com.example.viewmodelapi.adapters.ItemRecyclerAdapter
import com.example.viewmodelapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var recyclerAdapter: ItemRecyclerAdapter
//    lateinit var recyclerAdapter2: RecyclerViewAdapter
    lateinit var btn:Button
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val appsFragment =AppsFragment()
        val entriesFragment = EntriesFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_layout,appsFragment)
            commit()
        }

        binding.btn.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_layout,entriesFragment)
                addToBackStack(null)
                commit()
            }
        }

    }




}