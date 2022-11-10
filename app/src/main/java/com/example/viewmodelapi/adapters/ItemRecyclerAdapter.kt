package com.example.viewmodelapi.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.viewmodelapi.R
import com.example.viewmodelapi.databinding.DesignBinding
import com.example.viewmodelapi.model.firs_api_model.Result

class ItemRecyclerAdapter(): RecyclerView.Adapter<ItemRecyclerAdapter.MyViewHolder>(){

    var items = ArrayList<Result>()

    fun setUpdateData(items:ArrayList<Result>){
        this.items = items
        notifyDataSetChanged()
    }
    class MyViewHolder(private var binding:DesignBinding):RecyclerView.ViewHolder(binding.root){
//        val textview = view.findViewById<TextView>(R.id.tv1)
        fun bind(data: Result){
            binding.appsData = data
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
        val binding = DesignBinding.inflate(view)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items.get(position))
    }


//    var limit = 150
    override fun getItemCount(): Int {

        return items.size


    }
}