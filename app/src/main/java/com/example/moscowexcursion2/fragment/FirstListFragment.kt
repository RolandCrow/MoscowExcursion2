package com.example.moscowexcursion2.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.GridLayoutManager
import com.example.moscowexcursion2.adapter.ExcursionAdapter
import com.example.moscowexcursion2.databinding.FragmentListBinding
import com.example.moscowexcursion2.model.Data
import com.example.moscowexcursion2.viewmodel.ListFragmentViewModel


class FirstListFragment : Fragment() {

    private lateinit var listFragmentViewModel: ListFragmentViewModel
    private val listExcursionAdapter = ExcursionAdapter(arrayListOf())

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!



    private val excursionDataObserver  = Observer<List<Data>> { list ->
        list.let {
            binding.exursionImages.visibility = View.VISIBLE
            listExcursionAdapter.updateList(it)
        }

    }

    private val loadingObserver = Observer<Boolean> { isLoading ->
        binding.Bar.visibility = if(isLoading) View.VISIBLE else View.GONE
        if(isLoading) {
            binding.exursionImages.visibility = View.GONE
            binding.onError.visibility = View.GONE
        }

    }




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listFragmentViewModel = ViewModelProvider(this).get(ListFragmentViewModel::class.java)
        listFragmentViewModel.excursion.observe(this, excursionDataObserver)
        listFragmentViewModel.loading.observe(this, loadingObserver)
        listFragmentViewModel.refresh()
        binding.exursionImages.apply {
            layoutManager = GridLayoutManager(context,1 )
            adapter = listExcursionAdapter
        }


        binding.refreshLayout.setOnRefreshListener {
            binding.onError.visibility = View.GONE
            binding.exursionImages.visibility = View.GONE
            binding.Bar.visibility = View.VISIBLE
            binding.refreshLayout.isRefreshing = false
            listFragmentViewModel.refresh()
        }




     }




}