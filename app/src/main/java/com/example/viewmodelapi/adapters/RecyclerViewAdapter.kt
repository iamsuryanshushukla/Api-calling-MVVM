package com.example.viewmodelapi.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.viewmodelapi.model.second_api_model.Entry
import com.example.viewmodelapi.R
import com.example.viewmodelapi.databinding.Design2Binding
import com.example.viewmodelapi.databinding.DesignBinding
import com.example.viewmodelapi.databinding.FragmentAppsBinding

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {
    var items : List<Entry> = emptyList()

    fun setUpdateData(items:List<Entry>){
        this.items = items
        notifyDataSetChanged()
    }
    class MyViewHolder(private val binding: Design2Binding):RecyclerView.ViewHolder(binding.root){
//        val textview = view.findViewById<TextView>(R.id.tv1)
        fun bind(data: Entry){
//            textview.text = data.API
            binding.entriesData = data
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
        val binding = Design2Binding.inflate(view)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items.get(position))
    }


    var limit = 150
    override fun getItemCount(): Int {
        return if (items.size < limit){
            items.size
        }else{
            limit
        }


    }
}