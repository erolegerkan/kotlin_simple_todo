package com.example.todoapp.di

import android.content.Context
import androidx.room.Room
import com.example.todoapp.data.datasource.RecordDataSource
import com.example.todoapp.data.repo.RecordRepository
import com.example.todoapp.room.Database
import com.example.todoapp.room.RecordDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent :: class)
class AppModule {
    @Provides
    @Singleton
    fun provideRecordRepository(recordDataSource: RecordDataSource) : RecordRepository{
        return RecordRepository(recordDataSource)
    }

    @Provides
    @Singleton
    fun provideRecordDataSource(recordDao: RecordDao) : RecordDataSource{
        return RecordDataSource(recordDao)
    }

    @Provides
    @Singleton
    fun provideRecordDao(@ApplicationContext context: Context) : RecordDao{
        val database = Room.databaseBuilder(context, Database::class.java,"todos.sqlite")
            .createFromAsset("todos.sqlite")
            .build()
        return database.getRecordDao()
    }



}