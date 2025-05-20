package com.example.todoapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.Navigator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp.R
import com.example.todoapp.data.entity.RecordEntity
import com.example.todoapp.databinding.FragmentMainBinding
import com.example.todoapp.ui.adapters.ToDoAdapter

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater,container,false)

        binding.fabMain.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.mainToSaveRecordsNav)
        }

        val records = ArrayList<RecordEntity>()
        val record1 = RecordEntity(1,"MVVM eklenecek")
        val record2 = RecordEntity(2,"Hilt - DI eklenecek")
        val record3 = RecordEntity(3,"Room eklenecek")
        records.add(record1)
        records.add(record2)
        records.add(record3)

        val toDoAdapter = ToDoAdapter(requireContext(),records)
        binding.rvRecords.adapter = toDoAdapter
        binding.rvRecords.layoutManager = LinearLayoutManager(requireContext())

        return binding.root
    }


}