package com.example.bankapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.bankapp.models.Transaction
import com.example.bankapp.repository.BankRepository
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { BankViewModel(get()) }
}

class BankViewModel(private val repository: BankRepository) : ViewModel() {

    val transactions: LiveData<Transaction> = liveData {
        emit(repository.getTransactions())
    }

}