package com.ganesh.bitcoinapp.binding

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("visibilities")
fun viewVisibilities(progressBar: View, status: Boolean) {
    if (status) {
        progressBar.visibility = View.VISIBLE
    } else {
        progressBar.visibility = View.GONE
    }

}