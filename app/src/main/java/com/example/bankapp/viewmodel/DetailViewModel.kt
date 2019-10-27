package com.example.bankapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.bankapp.utils.globalSkus
import com.example.bankapp.models.TransactionAmount
import com.example.bankapp.repository.BankRepository

class DetailViewModel(private val repository: BankRepository) : ViewModel() {

    val rates = liveData {
        emit(repository.getRates())
    }

    fun getTransactionsBySku(sku: String): ArrayList<TransactionAmount>? {
        globalSkus.mapNotNull { return globalSkus[sku] }
        return null
    }

}