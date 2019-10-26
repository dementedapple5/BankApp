package com.example.bankapp

import android.service.media.MediaBrowserService
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.example.bankapp.models.Rate

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}


fun Double.convertCurrency(from: String, to: String, rates: List<Rate>): Double {

    if (from == to) {
        return this
    }

    for (rate in rates) {
        if (rate.from == from && rate.to == to) {
            return this * rate.rate
        }
    }

    for (rate in rates) {
        if (rate.from == from) {
           return (this * rate.rate).convertCurrency(rate.to, to, rates)
        }
    }

    return 0.0
}