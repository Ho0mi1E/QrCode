package com.example.qrcode.presintation.viewModels

import androidx.lifecycle.viewModelScope
import com.example.qrcode.domain.interactor.CodeInteractor
import com.example.qrcode.domain.interactor.ScanCodeForView
import kotlinx.coroutines.launch
import javax.inject.Inject

class ScannerViewModel @Inject constructor(private val interactor: CodeInteractor) :
    BaseViewModel() {

    fun putScanInDataBase(text: String, date: String) {
        viewModelScope.launch {
            interactor.saveCode(ScanCodeForView(text = text, date = date))
        }
    }
}