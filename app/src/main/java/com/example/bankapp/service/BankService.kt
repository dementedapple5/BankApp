package com.example.bankapp.service

import com.example.bankapp.models.Transaction
import retrofit2.Response
import retrofit2.http.GET

const val apiUrl =  "http://quiet-stone-2094.herokuapp.com/"

interface BankService {

    @GET("transactions.json")
    suspend fun getTransactions() : ArrayList<Transaction>

}