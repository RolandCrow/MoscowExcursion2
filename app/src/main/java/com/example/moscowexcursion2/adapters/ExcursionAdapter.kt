package com.example.moscowexcursion2.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.moscowexcursion2.databinding.ExcursionRouteBinding
import com.example.moscowexcursion2.model.Data
import com.example.moscowexcursion2.model.Routes

class ExcursionAdapter(private var routesData: List<Routes>): RecyclerView.Adapter<ExcursionAdapter.ExcursionViewHolder>() {

    class  ExcursionViewHolder(val binding: ExcursionRouteBinding): RecyclerView.ViewHolder(binding.root)


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
        val binding = ExcursionRouteBinding.inflate(layoutInflater)

        return ExcursionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ExcursionViewHolder, position: Int) {
        holder.binding.route = routesData[position]
        holder.binding.positionOfRoute.text = String.format("%d", position + 1)
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
      return   routesData.size
    }


}