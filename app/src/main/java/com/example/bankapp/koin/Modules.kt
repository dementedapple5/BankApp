package com.example.bankapp.koin

import com.example.bankapp.repository.BankRepository
import com.example.bankapp.service.BankService
import com.example.bankapp.service.apiUrl
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    factory { provideOkHttpClient() }
    factory { provideBankService(get()) }
    single { provideRetrofit(get()) }
}

val repositoryModule = module {
    factory { BankRepository(get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(apiUrl).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient().newBuilder().build()
}

fun provideBankService(retrofit: Retrofit): BankService = retrofit.create(BankService::class.java)
