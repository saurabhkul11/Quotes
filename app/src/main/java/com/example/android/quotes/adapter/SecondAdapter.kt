package com.example.android.quotes.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.quotes.R
import com.example.android.quotes.adapter.SecondAdapter.SecondViewHolder
import com.example.android.quotes.databinding.RecvItem3Binding
import com.example.android.quotes.models.User

class SecondAdapter(val context: Context):RecyclerView.Adapter<SecondViewHolder> (){

    var list = mutableListOf<User>()
    private var selectedItemPosition: Int = 0


    inner class SecondViewHolder(val binding: RecvItem3Binding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecvItem3Binding.inflate(inflater, parent, false)
        return SecondViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SecondViewHolder, position: Int) {
        val currentItem = list[position]
        holder.binding.txt1.text=currentItem.name
        holder.binding.txt2.text=currentItem.userName

        holder.itemView.setOnClickListener {

            selectedItemPosition = holder.adapterPosition
            notifyDataSetChanged()

        }
        if (selectedItemPosition==holder.adapterPosition)
        {
            holder.itemView.setBackgroundColor(context.getColor(android.R.color.holo_orange_light))
        }
        else
        {
            holder.itemView.setBackgroundColor(context.getColor(android.R.color.holo_green_light))
        }

    }
    fun fdata(dlist:List<User>){

        this.list=dlist.toMutableList()
        notifyDataSetChanged()

    }
}