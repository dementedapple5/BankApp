package com.example.bankapp.view.adapter

import android.content.Intent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bankapp.R
import com.example.bankapp.utils.inflate
import com.example.bankapp.view.activity.DetailActivity
import kotlinx.android.synthetic.main.sku_item.view.*


class DashboardAdapter(val skus: List<String>) : RecyclerView.Adapter<DashboardAdapter.TransactionVH>() {


    class TransactionVH(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private var view: View = itemView
        private var sku: String? = null

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val mContext = itemView.context
            val showSkuIntent = Intent(mContext, DetailActivity::class.java)
            showSkuIntent.putExtra("SKU", sku)
            mContext.startActivity(showSkuIntent)
        }

        fun bindTransaction(sku: String){
            this.sku = sku
            view.skuName.text = sku
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionVH = TransactionVH(parent.inflate( R.layout.sku_item))

    override fun getItemCount(): Int = skus.size

    override fun onBindViewHolder(holder: TransactionVH, position: Int) = holder.bindTransaction(skus[position])

}