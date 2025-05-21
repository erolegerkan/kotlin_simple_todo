package com.example.todoapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.Navigator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp.R
import com.example.todoapp.data.entity.RecordEntity
import com.example.todoapp.databinding.FragmentMainBinding
import com.example.todoapp.ui.adapters.ToDoAdapter
import com.example.todoapp.ui.viewmodels.MainViewModel

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater,container,false)

        binding.fabMain.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.mainToSaveRecordsNav)
        }

        viewModel.recordList.observe(viewLifecycleOwner){
            val recordAdapter = ToDoAdapter(requireContext(),it,viewModel)
            binding.rvRecords.adapter = recordAdapter
        }

        binding.rvRecords.layoutManager = LinearLayoutManager(requireContext())

        binding.svMain.setOnQueryTextListener(object : android.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.searchRecord(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.searchRecord(newText)
                return true
            }
        })

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: MainViewModel by viewModels()
        viewModel = tempViewModel

    }

    override fun onResume() {
        super.onResume()
        viewModel.getAllRecords()
    }

}