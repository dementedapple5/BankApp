package com.example.bankapp

import android.app.Application
import com.example.bankapp.koin.networkModule
import com.example.bankapp.koin.repositoryModule
import com.example.bankapp.koin.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module

class BankApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@BankApplication)
            modules(listOf(repositoryModule, networkModule, viewModelModule))
        }
    }
}