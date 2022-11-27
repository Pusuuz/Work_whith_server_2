package com.example.database.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.database.R
import com.example.database.databinding.FirstFragmentBinding
import com.example.database.db.SleepNight
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FirstFragment: Fragment(R.layout.first_fragment) {

    private val viewModel: FirstViewModel by viewModels()
    private var _binding: FirstFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FirstFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.Next.setOnClickListener {

            val job = binding.JobField.text.toString()
            val age = binding.AgeField.text.toString()
            val name =   binding.NameField.text.toString()

            val data = SleepNight(
                userId = 0,
                userName = name,
                age = age,
                job = job
            )

            CoroutineScope(Dispatchers.IO).launch {
                viewModel.saveToDB(data)
            }


            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }

    }

}