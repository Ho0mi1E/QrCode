package com.example.qrcode.domain.di

import com.example.qrcode.domain.CodeRepository
import com.example.qrcode.domain.interactor.CodeInteractor
import com.example.qrcode.domain.interactor.CodeInteractorImpl
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun getInteractor(repository: CodeRepository): CodeInteractor {
        return CodeInteractorImpl(repository)
    }
}