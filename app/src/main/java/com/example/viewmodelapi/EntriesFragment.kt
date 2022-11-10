package com.example.viewmodelapi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewmodelapi.adapters.RecyclerViewAdapter
import com.example.viewmodelapi.databinding.FragmentEntriesBinding
import com.example.viewmodelapi.viewmodels.MainActivityViewModel

class EntriesFragment : Fragment() {

    lateinit var recylerAdapter: RecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentEntriesBinding>(inflater,R.layout.fragment_entries,container,false)

        binding.rvEntries.layoutManager = LinearLayoutManager(context)

        binding.setVariable(BR.entriesViewModel,initViewModel())



        return binding.root
    }
    private fun initViewModel():MainActivityViewModel {

        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        viewModel.getRecyclereListObserver().observe(viewLifecycleOwner) { list ->
            viewModel.setEntriesAdapter(list)
        }
        return viewModel
    }
}