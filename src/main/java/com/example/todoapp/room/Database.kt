package com.example.todoapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todoapp.data.entity.RecordEntity

@Database(entities = [RecordEntity::class], version = 1)
abstract class Database : RoomDatabase() {
    abstract fun getRecordDao() : RecordDao
}