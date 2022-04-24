package com.example.qrcode.domain

import com.example.qrcode.data.storage.ScanCodeEntity
import kotlinx.coroutines.flow.Flow

interface CodeRepository {

    fun getAllCode(): Flow<List<ScanCodeEntity>>

    suspend fun saveCode(scanCode: ScanCodeEntity)
}