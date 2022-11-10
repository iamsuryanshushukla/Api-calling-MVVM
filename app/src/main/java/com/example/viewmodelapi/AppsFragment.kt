package com.example.viewmodelapi

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.viewmodelapi.Database.EntryDataBase
import com.example.viewmodelapi.adapters.ItemRecyclerAdapter
import com.example.viewmodelapi.databinding.ActivityMainBinding
import com.example.viewmodelapi.databinding.FragmentAppsBinding
import com.example.viewmodelapi.databinding.FragmentEntriesBinding
import com.example.viewmodelapi.viewmodels.MainViewModel

class AppsFragment : Fragment() {
    lateinit var recyclerAdapter: ItemRecyclerAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentAppsBinding>(inflater,R.layout.fragment_apps,container,false)

        binding.rvApps.layoutManager = LinearLayoutManager(context)

        context?.let { EntryDataBase.getDatabase(context = it) }



//        recyclerAdapter = ItemRecyclerAdapter()


        val decoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)

        binding.setVariable(BR.appsViewmodel,initViewModel())
        binding.rvApps.addItemDecoration(decoration)


        return binding.root
    }




    private fun initViewModel():MainViewModel {

        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.getRecyclereListObserver().observe(viewLifecycleOwner, Observer {

            if (it!=null){
                viewModel.setAdapterData(it.feed.results)
            }else {

                Toast.makeText(context,"error", Toast.LENGTH_LONG).show()

            }
        })

        viewModel.makeApiCall()
        return viewModel

    }
}