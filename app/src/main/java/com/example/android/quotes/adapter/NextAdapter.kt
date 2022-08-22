package com.example.android.quotes.adapter

import android.R
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.quotes.databinding.RecvItem2Binding
import com.example.android.quotes.models.User
import com.squareup.picasso.Picasso

class NextAdapter(val context: Context): RecyclerView.Adapter<NextAdapter.NewViewHolder>() {


    var list = mutableListOf<User>()
    private var selectedItemPosition: Int = 0


    fun put_data(list: List<User>) {
        this.list = list.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = RecvItem2Binding.inflate(inflater, parent, false)
        return NewViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }


    override fun onBindViewHolder(holder: NewViewHolder, position: Int) {

        val currentItem = list[position]

        holder.binding.textLocation.text = currentItem.address?.city.toString()
        holder.binding.textCustomerId.text = currentItem.id.toString()
        holder.binding.textClientName.text = currentItem.name
        holder.binding.textPhoneNo.text = currentItem.phone
       // Picasso.with(context).load(currentItem.website).into(holder.binding.imgg)
        holder.itemView.setOnClickListener {

            selectedItemPosition = holder.adapterPosition
            notifyDataSetChanged()

        }
        if (selectedItemPosition==holder.adapterPosition)
        {
            holder.itemView.setBackgroundColor(context.getColor(R.color.holo_orange_light))
        }
        else
        {
            holder.itemView.setBackgroundColor(context.getColor(R.color.transparent))
        }

    }
    class NewViewHolder(val binding: RecvItem2Binding) : RecyclerView.ViewHolder(binding.root) {}


}
