package com.ganesh.bitcoinapp.presentation.hostoricalrate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ganesh.bitcoinapp.R
import com.ganesh.bitcoinapp.databinding.AdapterBitcoinHistoricalListBinding
import com.ganesh.bitcoinapp.model.BitCoinHistoricalData


class HistoricalRateAdapter : RecyclerView.Adapter<HistoricalRateAdapter.ViewHolder>() {

    private var items: List<BitCoinHistoricalData> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ItemViewHolder(
            parent
        )
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        if (holder is ItemViewHolder && items.size > position) {
            holder.bind(items.get(position))
        }

    }

    /**
     * updating data to adapter
     */
    fun update(data: List<BitCoinHistoricalData>) {
        this.items = data
        notifyDataSetChanged()
    }


    abstract class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    class ItemViewHolder(
        private val parent: ViewGroup,
        private val binding: AdapterBitcoinHistoricalListBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.adapter_bitcoin_historical_list,
            parent,
            false
        )
    ) : ViewHolder(binding.root) {

        fun bind(model: BitCoinHistoricalData) {
            binding.dateValue = model
        }
    }

}