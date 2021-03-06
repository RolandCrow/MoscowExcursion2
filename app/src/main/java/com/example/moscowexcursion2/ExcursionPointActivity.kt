package com.example.moscowexcursion2

import android.os.Bundle
import android.os.Parcelable
import android.os.PersistableBundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.moscowexcursion2.adapters.ExcursionAdapter
import com.example.moscowexcursion2.adapters.ExcursionPointAdapter
import com.example.moscowexcursion2.databinding.ActivityExcursionPointBinding
import com.example.moscowexcursion2.model.Data
import com.example.moscowexcursion2.model.InfoExcursion
import com.example.moscowexcursion2.model.Routes
import com.example.moscowexcursion2.util.Handler
import com.example.moscowexcursion2.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExcursionPointActivity  : AppCompatActivity() {

    private lateinit var excursionAdapter: ExcursionAdapter

    private val binding: ActivityExcursionPointBinding by lazy {
        DataBindingUtil.setContentView<ActivityExcursionPointBinding>(this, R.layout.activity_excursion_point).apply {
            lifecycleOwner = this@ExcursionPointActivity

        }
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_excursion_point)

        val myData = intent.getParcelableExtra<Parcelable>("data") as Data
        Log.e("MyDDDDDwelfme'mwfwml;fwe;mf;we", myData.toString())
        binding.excursion = myData

        excursionAdapter = ExcursionAdapter(myData.routes)
        binding.adapter = excursionAdapter

        val handler = Handler()
        binding.handler = handler

    }





}