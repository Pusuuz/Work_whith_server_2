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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class SecondFragment:Fragment(R.layout.second_fragment) {


    private val viewModel: SecondViewModel by viewModels()
    private var _binding: SecondFragmentBinding? = null
    private val binding get ()= _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SecondFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        CoroutineScope(Dispatchers.IO).launch {
            val job = viewModel.getUserData()?.job
            val age = viewModel.getUserData()?.age
            val name =  viewModel.getUserData()?.userName

            withContext(Dispatchers.Main){
                binding.Age.text = age
                binding.Name.text = name
                binding.Job.text = job
            }


        }


    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }




}