package com.example.bankapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.bankapp.models.Transaction
import com.example.bankapp.models.TransactionAmount
import com.example.bankapp.repository.BankRepository

class DashboardViewModel(private val repository: BankRepository) : ViewModel() {

    val transactions = liveData {
        emit(repository.getTransactions())
    }

    fun getSkusFromTransactions(transactions: List<Transaction>) : HashMap<String, ArrayList<TransactionAmount>>{
        val skus: LinkedHashMap<String, ArrayList<TransactionAmount>> = LinkedHashMap()
        for (transaction in transactions) {
            if (!skus.containsKey(transaction.sku)) {
                skus[transaction.sku] = ArrayList()
            }
            skus[transaction.sku]?.add(TransactionAmount(transaction.amount, transaction.currency))
        }
        return skus
    }


}