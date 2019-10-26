package com.example.bankapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bankapp.viewmodel.BankViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val viewModel: BankViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println(viewModel.transactions)

    }




}
