package com.ganesh.bitcoinapp.presentation.currency

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ganesh.bitcoinapp.R
import com.ganesh.bitcoinapp.databinding.AdapterCurrencyListBinding


class CurrencyListAdapter : RecyclerView.Adapter<ItemViewHolder>() {

    private var items: MutableList<com.ganesh.bitcoinapp.model.CurrencyData> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(parent)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    /**
     * updating data to adapter
     */
    fun update(data: List<com.ganesh.bitcoinapp.model.CurrencyData>) {

        this.items.let {
            this.items.addAll(data)
        }.let {
            notifyDataSetChanged()
        }

    }

    abstract class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}


class ItemViewHolder(
    private val parent: ViewGroup,
    private val binding: AdapterCurrencyListBinding = DataBindingUtil.inflate(
        LayoutInflater.from(parent.context),
        R.layout.adapter_currency_list,
        parent,
        false
    )
) : CurrencyListAdapter.ViewHolder(binding.root) {

    fun bind(item: com.ganesh.bitcoinapp.model.CurrencyData) {
        binding.currenyModel = item
    }
}