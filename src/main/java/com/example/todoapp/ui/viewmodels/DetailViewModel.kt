package com.example.todoapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.todoapp.data.entity.RecordEntity
import com.example.todoapp.data.repo.RecordRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(var recordRepository: RecordRepository) : ViewModel(){
        fun updateRecord(recordEntity: RecordEntity){
            CoroutineScope(Dispatchers.Main).launch{
                recordRepository.updateRecord(recordEntity)
            }
        }

        fun deleteRecord(recordEntity: RecordEntity){
            CoroutineScope(Dispatchers.Main).launch{
                recordRepository.deleteRecord(recordEntity)
            }
        }
}