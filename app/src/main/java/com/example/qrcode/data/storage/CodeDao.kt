package com.example.qrcode.data.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CodeDao {

    @Query("SELECT * FROM codes")
    fun getAllCode(): Flow<List<ScanCodeEntity>>

    @Insert
    suspend fun saveCode(scanCode: ScanCodeEntity)
}