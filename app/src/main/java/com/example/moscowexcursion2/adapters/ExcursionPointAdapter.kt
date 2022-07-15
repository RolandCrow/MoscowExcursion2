package com.example.moscowexcursion2.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.moscowexcursion2.databinding.ExursionItemBinding
import com.example.moscowexcursion2.model.Data
import com.example.moscowexcursion2.model.InfoExcursion
import com.example.moscowexcursion2.util.Handler

class ExcursionPointAdapter(private var excursionListData: InfoExcursion): RecyclerView.Adapter<ExcursionPointAdapter.ExcursionViewHolder>() {

    class ExcursionViewHolder(val binding: ExursionItemBinding): RecyclerView.ViewHolder(binding.root)


    companion object: DiffUtil.ItemCallback<Data>(){
        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExcursionViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ExursionItemBinding.inflate(layoutInflater)

        val handler = Handler()
        binding.handler = handler

        return ExcursionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ExcursionViewHolder, position: Int) {
        holder.binding.excursion = excursionListData.data[position]
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return excursionListData.data.size
    }


}