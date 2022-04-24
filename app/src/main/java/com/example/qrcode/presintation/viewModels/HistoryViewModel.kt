package com.example.qrcode.presintation.viewModels

import androidx.lifecycle.viewModelScope
import com.example.qrcode.domain.interactor.CodeInteractor
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class HistoryViewModel @Inject constructor(
    private val interactor: CodeInteractor
) : BaseViewModel() {

    init {
        getDataForView()
    }

    private fun getDataForView() {
        interactor.getAllCode()
            .map { _codeList.postValue(it) }
            .launchIn(viewModelScope)
    }

}
