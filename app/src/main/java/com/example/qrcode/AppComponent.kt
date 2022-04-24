package com.example.qrcode

import android.content.Context
import com.example.qrcode.data.di.DataModule
import com.example.qrcode.data.di.RoomModule
import com.example.qrcode.domain.di.DomainModule
import com.example.qrcode.presintation.codeHistory.HistoryFragment
import com.example.qrcode.presintation.di.ViewModelModule
import com.example.qrcode.presintation.scanner.ScannerFragment
import dagger.BindsInstance
import dagger.Component

@Component(modules = [DataModule::class, RoomModule::class, DomainModule::class, ViewModelModule::class])
interface AppComponent {

    fun inject(target: ScannerFragment)
    fun inject(target: HistoryFragment)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun buildContext(context: Context): Builder
        fun build(): AppComponent
    }
}
