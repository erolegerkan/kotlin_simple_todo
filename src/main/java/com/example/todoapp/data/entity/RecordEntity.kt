package com.example.todoapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "todos")
data class RecordEntity(@PrimaryKey(autoGenerate = true)
                        @ColumnInfo(name = "id") @NotNull var record_id : Int,
                        @ColumnInfo(name = "record") @NotNull var record_title : String) : Serializable {

}