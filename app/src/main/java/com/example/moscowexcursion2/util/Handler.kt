package com.example.moscowexcursion2.util

import android.content.Context
import android.content.Intent
import com.example.moscowexcursion2.ExcursionActivity
import com.example.moscowexcursion2.ExcursionPointActivity
import com.example.moscowexcursion2.model.Data
import com.example.moscowexcursion2.model.Routes

class Handler {

    fun onClick(data: Data, context: Context) {
        val intent = Intent(context, ExcursionPointActivity::class.java)
        intent.putExtra("data", data)
        context.startActivity(intent)
    }

    fun onClickToStart(routes: ArrayList<Routes>, context: Context ) {
        val intent = Intent(context, ExcursionActivity::class.java)
        intent.putParcelableArrayListExtra("routes", routes)
        context.startActivity(intent)
    }

}