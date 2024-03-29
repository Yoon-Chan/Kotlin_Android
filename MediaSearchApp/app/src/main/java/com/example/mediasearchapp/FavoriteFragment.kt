package com.example.mediasearchapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mediasearchapp.databinding.FragmentFavoriteBinding
import com.example.mediasearchapp.databinding.FragmentSearchBinding
import com.example.mediasearchapp.list.ListAdapter

class FavoriteFragment : Fragment() {

    private var binding: FragmentFavoriteBinding? = null
    //private val binding get() = _binding!!

    private val adapter by lazy { ListAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentFavoriteBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.let {
            it.recyclerView.adapter = adapter
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}