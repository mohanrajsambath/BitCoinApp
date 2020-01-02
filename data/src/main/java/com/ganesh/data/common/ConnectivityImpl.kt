package com.ganesh.data.common

import android.content.Context
import android.net.ConnectivityManager

/**
 * Created by GaneshKumar
 *
 * connectivity implementation
 */
class ConnectivityImpl(private val context: Context) : Connectivity {

    override fun hasNetworkAccess(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val info = connectivityManager.activeNetworkInfo
        return info != null && info.isConnected
    }
}