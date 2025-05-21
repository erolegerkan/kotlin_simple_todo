package com.example.todoapp.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapp.data.entity.RecordEntity
import com.example.todoapp.data.repo.RecordRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(var recordsRepository: RecordRepository) : ViewModel() {
    val recordList = MutableLiveData<List<RecordEntity>>()

    init {
        getAllRecords()
    }

    fun getAllRecords(){
        CoroutineScope(Dispatchers.Main).launch {
            recordList.value = recordsRepository.getAllRecords()
        }
    }

    fun deleteRecords(recordEntity: RecordEntity){
        CoroutineScope(Dispatchers.Main).launch {
            recordsRepository.deleteRecord(recordEntity)
        }
        getAllRecords()
    }

    fun searchRecord(searchWord : String){
        CoroutineScope(Dispatchers.Main).launch {
            recordsRepository.searchRecord(searchWord)
        }
    }

}