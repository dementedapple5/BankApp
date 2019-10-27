package com.example.bankapp.models

import android.os.Parcel
import android.os.Parcelable


data class TransactionAmount(val amount: Double, val currency: String) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readDouble(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeDouble(amount)
        parcel.writeString(currency)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TransactionAmount> {
        override fun createFromParcel(parcel: Parcel): TransactionAmount {
            return TransactionAmount(parcel)
        }

        override fun newArray(size: Int): Array<TransactionAmount?> {
            return arrayOfNulls(size)
        }
    }
}