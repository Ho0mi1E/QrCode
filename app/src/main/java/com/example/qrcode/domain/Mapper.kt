package com.example.qrcode.domain

import com.example.qrcode.data.storage.ScanCodeEntity
import com.example.qrcode.domain.interactor.ScanCodeForView

fun ScanCodeEntity.toScanCodeForView() =
    ScanCodeForView(text = text, date = date)

fun ScanCodeForView.toScanCodeEntity() =
    ScanCodeEntity(text = text, date = date)