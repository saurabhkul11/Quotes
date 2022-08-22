package com.example.android.quotes

import android.R
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.quotes.databinding.RecvItemBinding
import com.example.android.quotes.models.User


class NewAdapter(val context: Context): RecyclerView.Adapter<NewAdapter.NewViewHolder>() {

    var list = mutableListOf<User>()
    private var selectedItemPosition: Int = 0

    val  intial =-1
    fun give_data(list: List<User>)
    {
        this.list = list.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecvItemBinding.inflate(inflater, parent, false)
        return NewViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }


    override fun onBindViewHolder(holder: NewViewHolder, position: Int) {

       val currentItem = list[position]

       holder.binding.textLocation.text = currentItem.address?.city.toString()
       holder.binding.textCustomer.text = currentItem.id.toString()
       holder.binding.textClient.text = currentItem.name
        holder.binding.textPhone.text = currentItem.phone
       //Picasso.with(context).load(currentItem.imageUrl).into(holder.binding.img)
       holder.itemView.setOnClickListener {
           selectedItemPosition = holder.adapterPosition
           notifyDataSetChanged()
       }

       if (selectedItemPosition == holder.adapterPosition)
       {
           holder.itemView.setBackgroundColor(context.getColor(R.color.holo_orange_light))
       }
       else
       {
           holder.itemView.setBackgroundColor(context.getColor(R.color.transparent))
       }
   }
    class NewViewHolder(val binding: RecvItemBinding) : RecyclerView.ViewHolder(binding.root) {}
}






