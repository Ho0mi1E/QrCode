package com.example.qrcode.domain.interactor

import kotlinx.coroutines.flow.Flow

interface CodeInteractor {

    fun getAllCode(): Flow<List<ScanCodeForView>>

    suspend fun saveCode(code: ScanCodeForView)
}