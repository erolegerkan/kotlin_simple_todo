package com.example.todoapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.todoapp.R
import com.example.todoapp.data.entity.RecordEntity
import com.example.todoapp.databinding.FragmentSaveRecordsBinding
import com.example.todoapp.ui.viewmodels.SaveRecordsViewModel

class SaveRecordsFragment : Fragment() {
    private lateinit var binding: FragmentSaveRecordsBinding
    private lateinit var viewModel: SaveRecordsViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSaveRecordsBinding.inflate(inflater,container,false)

        val recordText = binding.tvSave.text.toString()
        val record = RecordEntity(1,recordText)

        binding.btSave.setOnClickListener {
            viewModel.saveRecord(record)
        }

        return binding.root
    }


}