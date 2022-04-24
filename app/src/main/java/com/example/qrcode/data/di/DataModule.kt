package com.example.qrcode.data.di

import com.example.qrcode.data.CodeRepositoryImpl
import com.example.qrcode.data.storage.CodeDao
import com.example.qrcode.domain.CodeRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun getRepository(dao: CodeDao): CodeRepository {
        return CodeRepositoryImpl(dao)
    }
}