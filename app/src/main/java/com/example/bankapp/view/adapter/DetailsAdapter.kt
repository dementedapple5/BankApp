package com.example.bankapp.view.adapter

import android.content.Intent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bankapp.R
import com.example.bankapp.utils.inflate
import com.example.bankapp.models.TransactionAmount
import com.example.bankapp.view.activity.DetailActivity
import kotlinx.android.synthetic.main.transaction_item.view.*


class DetailsAdapter(val transactions: List<TransactionAmount>) : RecyclerView.Adapter<DetailsAdapter.TransactionVH>() {


    class TransactionVH(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private var view: View = itemView

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val mContext = itemView.context
            val showSkuIntent = Intent(mContext, DetailActivity::class.java)
            mContext.startActivity(showSkuIntent)
        }

        fun bindTransaction(transactionAmount: TransactionAmount){
            view.amount.text = transactionAmount.amount.toString()
            view.currency.text = transactionAmount.currency
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionVH = TransactionVH(parent.inflate( R.layout.transaction_item))

    override fun getItemCount(): Int = transactions.size

    override fun onBindViewHolder(holder: TransactionVH, position: Int) = holder.bindTransaction(transactions[position])

}