package com.example.todoapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.todoapp.data.entity.RecordEntity
import com.example.todoapp.data.repo.RecordRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class SaveRecordsViewModel @Inject constructor(var recordRepository: RecordRepository) : ViewModel() {
    fun saveRecord(recordEntity: RecordEntity){
        CoroutineScope(Dispatchers.IO).launch{
            recordRepository.saveRecord(recordEntity)
        }
    }
}