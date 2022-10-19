package com.example.viewmodelapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ItemRecyclerAdapter(): RecyclerView.Adapter<ItemRecyclerAdapter.MyViewHolder>(){

    var items = ArrayList<com.example.viewmodelapi.model.Result>()

    fun setUpdateData(items:ArrayList<com.example.viewmodelapi.model.Result>){
        this.items = items
        notifyDataSetChanged()
    }
    class MyViewHolder(view:View):RecyclerView.ViewHolder(view){
        val textview = view.findViewById<TextView>(R.id.tv1)
        fun bind(data:com.example.viewmodelapi.model.Result){
            textview.text = data.artistName
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.design,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items.get(position))
    }


//    var limit = 150
    override fun getItemCount(): Int {

        return items.size


    }
}