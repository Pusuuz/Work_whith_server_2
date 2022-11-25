package com.example.database.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.database.R
import com.example.database.databinding.SecondFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondFragment:Fragment(R.layout.second_fragment) {
     private val viewModel: SecondViewModel by viewModels()

    private var _binding: SecondFragmentBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get ()= _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SecondFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


        }