package com.example.todoapp.data.repo

import com.example.todoapp.data.datasource.RecordDataSource
import com.example.todoapp.data.entity.RecordEntity

class RecordRepository(var recordDataSource: RecordDataSource) {
    suspend fun getAllRecords() : List<RecordEntity> = recordDataSource.getAllRecords()

    suspend fun saveRecord(recordEntity: RecordEntity) = recordDataSource.saveRecord(recordEntity)

    suspend fun updateRecord(recordEntity: RecordEntity) = recordDataSource.updateRecord(recordEntity)

    suspend fun deleteRecord(recordEntity: RecordEntity) = recordDataSource.deleteRecord(recordEntity)

    suspend fun searchRecord(searchWord : String) : List<RecordEntity> = recordDataSource.searchRecord(searchWord)

}