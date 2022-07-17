package com.example.moscowexcursion2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.moscowexcursion2.adapters.ExcursionPointAdapter
import com.example.moscowexcursion2.databinding.ActivityMainBinding
import com.example.moscowexcursion2.model.InfoExcursion
import com.example.moscowexcursion2.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

 private val mainViewModel : MainViewModel by viewModels()




    private val binding : ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).apply {
            lifecycleOwner = this@MainActivity
        }
    }

    private lateinit var excursionPointAdapter: ExcursionPointAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setupObserver()

    }




    private fun setupObserver() {
        mainViewModel.excursionItem.observe(this) {
            Log.i("Successckvjv[owdv[kdv[k", it.data.toString())
            it.data?.let { main ->
                retrieveList(main)
            }
        }
    }

    private fun retrieveList(infoExcursion: InfoExcursion) {
        excursionPointAdapter = ExcursionPointAdapter(infoExcursion)
        binding.adapter = excursionPointAdapter
    }


}