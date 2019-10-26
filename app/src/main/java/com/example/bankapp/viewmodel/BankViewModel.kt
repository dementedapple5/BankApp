package com.example.bankapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.bankapp.models.Transaction
import com.example.bankapp.repository.BankRepository

class BankViewModel(private val repository: BankRepository) : ViewModel() {

    val transactions = liveData {
        emit(repository.getTransactions())
    }

    val rates = liveData {
        emit(repository.getRates())
    }


}