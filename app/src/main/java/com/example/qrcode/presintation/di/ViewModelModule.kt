package com.example.qrcode.presintation.di

import com.example.qrcode.domain.interactor.CodeInteractor
import com.example.qrcode.presintation.viewModels.HistoryViewModel
import com.example.qrcode.presintation.viewModels.ScannerViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

    @Provides
    fun getHistoryViewModel(interactor: CodeInteractor): HistoryViewModel {
        return HistoryViewModel(interactor)
    }

    @Provides
    fun getScannerViewModel(interactor: CodeInteractor): ScannerViewModel {
        return ScannerViewModel(interactor)
    }
}