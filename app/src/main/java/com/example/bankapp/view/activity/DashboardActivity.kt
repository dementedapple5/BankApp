package com.example.bankapp.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bankapp.R
import com.example.bankapp.utils.globalSkus
import com.example.bankapp.view.adapter.DashboardAdapter
import com.example.bankapp.viewmodel.DashboardViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel



class DashboardActivity : AppCompatActivity() {

    val viewModel: DashboardViewModel by viewModel()

    private lateinit var adapter: DashboardAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        linearLayoutManager = LinearLayoutManager(this)
        skusRv.layoutManager = linearLayoutManager

        if (globalSkus.isEmpty()) {
            viewModel.transactions.observe(this, Observer {transactions ->
                globalSkus = viewModel.getSkusFromTransactions(transactions)
                adapter = DashboardAdapter(globalSkus.keys.toList())
                skusRv.adapter = adapter
            })
        }


    }




}
