package com.example.moscowexcursion2.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.moscowexcursion2.R
import com.example.moscowexcursion2.model.Data
import com.example.moscowexcursion2.util.OnExcursionClick
import com.example.moscowexcursion2.databinding.ExursionItemBinding
import com.example.moscowexcursion2.fragment.FirstListFragmentDirections

class ExcursionAdapter(private val excursionList: ArrayList<Data>):
  RecyclerView.Adapter<ExcursionAdapter.ExcursionViewHolder>(), OnExcursionClick     {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExcursionViewHolder {
        return ExcursionViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.exursion_item,
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ExcursionViewHolder, position: Int) {
        val result = excursionList[position]
        holder.view.excursion = result
        holder.view.onClick = this
    }

    override fun getItemCount(): Int = excursionList.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newExcursion: List<Data>) {
        excursionList.clear()
        excursionList.addAll(newExcursion)
        notifyDataSetChanged()
    }

    override fun onClick(v: View) {
        for(excursion: Data in excursionList) {
            if(v.tag == excursion.title) {
                val action =
                         FirstListFragmentDirections.actionGoToDetails(excursion)
                Navigation.findNavController(v).navigate(action)
            }
        }
    }

    class ExcursionViewHolder(var view: ExursionItemBinding): RecyclerView.ViewHolder(view.root)

}

