package com.example.qrcode.data.storage

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "codes")
data class ScanCodeEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val text: String,
    val date: String
)