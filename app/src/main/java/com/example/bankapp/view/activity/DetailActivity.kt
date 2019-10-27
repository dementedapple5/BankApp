package com.example.bankapp.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bankapp.R
import com.example.bankapp.utils.convertCurrency
import com.example.bankapp.utils.globalRates
import com.example.bankapp.utils.globalSkus
import com.example.bankapp.models.Rate
import com.example.bankapp.utils.toHalfEven
import com.example.bankapp.view.adapter.DetailsAdapter
import com.example.bankapp.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.sku_item.*
import org.koin.android.viewmodel.ext.android.viewModel
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.round


class DetailActivity : AppCompatActivity() {

    val viewModel: DetailViewModel by viewModel()
    lateinit var sku: String
    private lateinit var adapter: DetailsAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private var totalUsd = 0.0
    private var totalEur = 0.0
    private var totalCad = 0.0
    private var totalAud = 0.0

    private val ratesObserver = Observer<List<Rate>> { rates ->
        globalRates = rates
        fillTotals(globalRates)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        linearLayoutManager = LinearLayoutManager(this)
        transactionsRv.layoutManager = linearLayoutManager

        if (intent.extras != null){
            sku = intent.extras?.getString("SKU")!!
            skuId.text = sku
            adapter = DetailsAdapter(globalSkus[sku]!!)
            transactionsRv.adapter = adapter

            if (globalRates.isEmpty()) {
                viewModel.rates.observe(this, ratesObserver)
            }else {
                fillTotals(globalRates)
            }

        } else {
            skuName.text = "Sku not received"
        }
    }

    private fun fillTotals(rates: List<Rate>){
        for (elem in globalSkus[sku]!!) {
            totalUsd += elem.amount.convertCurrency(elem.currency, "USD", rates)
            totalEur += elem.amount.convertCurrency(elem.currency, "EUR", rates)
            totalCad += elem.amount.convertCurrency(elem.currency, "CAD", rates)
            totalAud += elem.amount.convertCurrency(elem.currency, "AUD", rates)
        }

        usdTotalTv.text = totalUsd.toHalfEven().toString()
        eurTotalTv.text = totalEur.toHalfEven().toString()
        cadTotalTv.text = totalCad.toHalfEven().toString()
        audTotalTv.text = totalAud.toHalfEven().toString()
    }


}
