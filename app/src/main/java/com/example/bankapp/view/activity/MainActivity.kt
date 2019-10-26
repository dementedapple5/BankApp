package com.example.bankapp.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bankapp.R
import com.example.bankapp.view.adapter.TransactionAdapter
import com.example.bankapp.viewmodel.BankViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel



class MainActivity : AppCompatActivity() {

    val viewModel: BankViewModel by viewModel()
    private lateinit var adapter: TransactionAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        linearLayoutManager = LinearLayoutManager(this)
        transactionRv.layoutManager = linearLayoutManager

        viewModel.transactions.observe(this, Observer {transactions ->
            adapter = TransactionAdapter(transactions)
            transactionRv.adapter = adapter
        })

    }




}
