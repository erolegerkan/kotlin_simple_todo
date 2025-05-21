package com.example.todoapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.todoapp.R
import com.example.todoapp.data.entity.RecordEntity
import com.example.todoapp.databinding.FragmentDetailBinding
import com.example.todoapp.ui.viewmodels.DetailViewModel

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private lateinit var viewModel: DetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(inflater,container,false)

        val bundle:DetailFragmentArgs by navArgs()
        val arrivedRecord = bundle.records

        binding.tilTextDetail.setText(arrivedRecord.record_title)

        val updatedRecordText = binding.tvDetail.text.toString()
        val updatedRecord = RecordEntity(1,updatedRecordText)

        binding.btUpdate.setOnClickListener {
            viewModel.updateRecord(updatedRecord)
        }

        binding.btDone.setOnClickListener {
            viewModel.deleteRecord(arrivedRecord)
        }

        return binding.root
    }


}