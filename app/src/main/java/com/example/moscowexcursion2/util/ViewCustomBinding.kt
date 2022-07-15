package com.example.moscowexcursion2.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView

object ViewCustomBinding {

    @BindingAdapter(value = ["setImageUrl"])
    @JvmStatic
    fun SimpleDraweeView.bindImageUrl(url: String?) {
        if(url != null && url.isNotBlank()) {
            this.setImageURI(url)
        }
    }

    @BindingAdapter(value = ["setAdapter"])
    @JvmStatic
    fun RecyclerView.bindRecyclerViewAdapter(adapter: RecyclerView.Adapter<*>?) {
        this.run {
            this.setHasFixedSize(true)
            this.adapter = adapter
        }
    }
}

