package com.example.qrcode.domain.interactor

import com.example.qrcode.domain.CodeRepository
import com.example.qrcode.domain.toScanCodeEntity
import com.example.qrcode.domain.toScanCodeForView
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CodeInteractorImpl(private val repository: CodeRepository) : CodeInteractor {

    override suspend fun saveCode(code: ScanCodeForView) {
        repository.saveCode(code.toScanCodeEntity())

    }

    override fun getAllCode(): Flow<List<ScanCodeForView>> {
        return repository.getAllCode().map { list ->
            list.map { scanCode ->
                scanCode.toScanCodeForView()
            }
        }

    }
}