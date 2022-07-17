package com.example.moscowexcursion2

import android.os.Bundle
import android.os.Parcelable
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.moscowexcursion2.adapters.ExcursionAdapter
import com.example.moscowexcursion2.databinding.ActivityExcursionPointBinding
import com.example.moscowexcursion2.model.Data
import com.example.moscowexcursion2.util.Handler
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
        binding.excursion = myData

        excursionAdapter = ExcursionAdapter(myData.routes)
        binding.adapter = excursionAdapter

        val handler = Handler()
        binding.handler = handler

    }



}