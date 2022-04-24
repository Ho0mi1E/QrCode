package com.example.qrcode.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ScanCodeEntity::class], version = AppDatabase.VERSION)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        const val VERSION = 1
    }

    abstract fun getDao(): CodeDao
}