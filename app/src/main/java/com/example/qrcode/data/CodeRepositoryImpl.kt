package com.example.qrcode.data

import com.example.qrcode.data.storage.CodeDao
import com.example.qrcode.data.storage.ScanCodeEntity
import com.example.qrcode.domain.CodeRepository
import kotlinx.coroutines.flow.Flow

class CodeRepositoryImpl(private val dao: CodeDao) : CodeRepository {

    override suspend fun saveCode(scanCode: ScanCodeEntity) {
        dao.saveCode(scanCode)
    }

    override fun getAllCode(): Flow<List<ScanCodeEntity>> {
        return dao.getAllCode()
    }
}