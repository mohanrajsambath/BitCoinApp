package com.ganesh.bitcoinapp.presentation.currency

import android.view.View
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter

@BindingAdapter("visibilities")
fun progressBarVisibilities(progressBar: ProgressBar,status:Boolean){
    if(status){
        progressBar.visibility = View.VISIBLE
    }else{
        progressBar.visibility = View.GONE
    }

}