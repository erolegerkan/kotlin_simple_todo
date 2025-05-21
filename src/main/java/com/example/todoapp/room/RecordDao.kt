package com.example.todoapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todoapp.data.entity.RecordEntity

@Dao
interface RecordDao {
    @Query("SELECT * FROM todos")
    suspend fun getAllRecord() : List<RecordEntity>

    @Insert
    suspend fun saveRecord(record: RecordEntity)

    @Update
    suspend fun updateRecord(record: RecordEntity)

    @Delete
    suspend fun deleteRecord(record: RecordEntity)

    @Query("SELECT * FROM todos WHERE record LIKE '%' || :searchWord || '%' ")
    suspend fun searchRecord(searchWord : String) : List<RecordEntity>
}