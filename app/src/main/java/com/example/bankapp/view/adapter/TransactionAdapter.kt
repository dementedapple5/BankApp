package com.example.bankapp.view.adapter

import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bankapp.R
import com.example.bankapp.inflate
import com.example.bankapp.models.Transaction
import kotlinx.android.synthetic.main.transaction_item.view.*


class TransactionAdapter(val transactions: List<Transaction>) : RecyclerView.Adapter<TransactionAdapter.TransactionVH>() {


    class TransactionVH(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private var view: View = itemView
        private var transaction: Transaction? = null

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            Log.d("CLICKED", transaction!!.sku)
        }

        fun bindTransaction(transaction: Transaction){
            this.transaction = transaction
            view.sku.setText(transaction.sku)
            view.amount.setText(transaction.amount.toString())
            view.currency.setText(transaction.currency)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionVH = TransactionVH(parent.inflate( R.layout.transaction_item))

    override fun getItemCount(): Int = transactions.size

    override fun onBindViewHolder(holder: TransactionVH, position: Int) = holder.bindTransaction(transactions[position])

}