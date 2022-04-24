package com.example.qrcode.presintation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.qrcode.domain.interactor.ScanCodeForView

sealed class BaseViewModel : ViewModel() {

    protected val _codeList = MutableLiveData<List<ScanCodeForView>>()
    val codeList: LiveData<List<ScanCodeForView>> get() = _codeList
}