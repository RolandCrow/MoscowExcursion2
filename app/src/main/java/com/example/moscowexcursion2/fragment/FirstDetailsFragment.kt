package com.example.moscowexcursion2.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.moscowexcursion2.R
import com.example.moscowexcursion2.databinding.FragmentDetailsBinding
import com.example.moscowexcursion2.model.Data

class FirstDetailsFragment  : Fragment() {
        var excursion: Data? = null
        private lateinit var dataBinding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            excursion = FirstDetailsFragmentArgs.fromBundle(it).data
            dataBinding.descExc = excursion
        }
    }





}