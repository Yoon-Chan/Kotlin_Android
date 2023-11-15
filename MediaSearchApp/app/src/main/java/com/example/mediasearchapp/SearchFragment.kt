package com.example.mediasearchapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.mediasearchapp.databinding.FragmentFavoriteBinding
import com.example.mediasearchapp.databinding.FragmentSearchBinding
import com.example.mediasearchapp.list.ListAdapter
import com.example.mediasearchapp.repository.SearchRepositoryImpl

class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding: FragmentSearchBinding get() = _binding!!

    //private val binding get() = _binding!!
    private val adapter by lazy { ListAdapter() }
    private val viewModel: SearchViewModel by viewModels {
        SearchViewModel.SearchViewModelFactory(SearchRepositoryImpl(RetrofitManager.searchService))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        observeViewModel()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    fun searchKeyword(text: String) {
        Log.d("searchKeyword", "$text")
        viewModel.search(text)
    }

    private fun observeViewModel() {
        viewModel.listLiveData.observe(viewLifecycleOwner) { list ->
            with(binding) {
                if (list.isEmpty()) {
                    emptyTextView.isVisible = true
                    recyclerView.isVisible = false
                } else {
                    emptyTextView.isVisible = false
                    recyclerView.isVisible = true
                }
            }
            adapter.submitList(list)

        }
    }
}