package com.example.bankapp.repository

import com.example.bankapp.service.BankService
import org.koin.dsl.module



class BankRepository(val bankService: BankService) {

    suspend fun getTransactions() = bankService.getTransactions()

    suspend fun getRates() = bankService.getRates()


}