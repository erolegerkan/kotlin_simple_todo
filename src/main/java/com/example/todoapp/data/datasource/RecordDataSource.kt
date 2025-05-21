package com.example.todoapp.data.datasource

import com.example.todoapp.data.entity.RecordEntity
import com.example.todoapp.room.RecordDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RecordDataSource(var recordDao: RecordDao) {
    suspend fun getAllRecords() : List<RecordEntity> = withContext(Dispatchers.IO){
        return@withContext recordDao.getAllRecord()
    }

    suspend fun saveRecord(recordEntity: RecordEntity){
        recordDao.saveRecord(recordEntity)
    }

    suspend fun updateRecord(recordEntity: RecordEntity){
        recordDao.updateRecord(recordEntity)
    }

    suspend fun deleteRecord(recordEntity: RecordEntity){
        recordDao.deleteRecord(recordEntity)
    }

    suspend fun searchRecord(searchWord : String) : List<RecordEntity> = withContext(Dispatchers.IO){
        return@withContext recordDao.searchRecord(searchWord)
    }
}