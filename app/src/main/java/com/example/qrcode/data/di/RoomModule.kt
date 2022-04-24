package com.example.qrcode.data.di

import android.content.Context
import androidx.room.Room
import com.example.qrcode.data.storage.AppDatabase
import com.example.qrcode.data.storage.CodeDao
import dagger.Module
import dagger.Provides

@Module
class RoomModule {

    @Provides
    fun getAppDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "codes"
        ).build()
    }

    @Provides
    fun getDao(appDatabase: AppDatabase): CodeDao {
        return appDatabase.getDao()
    }
}