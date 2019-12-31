package com.ganesh.bitcoinapp.presentation.bitcoin


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.ganesh.bitcoinapp.databinding.FragmentBitcoinHistoricalBinding
import com.ganesh.bitcoinapp.presentation.hostoricalrate.BitCoinHistoricalAdapter
import com.ganesh.bitcoinapp.presentation.hostoricalrate.HistoricalViewModel


import com.ganesh.common.base.BaseFragment
import com.ganesh.common.base.BaseViewModel
import org.koin.android.viewmodel.ext.android.viewModel


/**
 * A simple [Fragment] subclass.
 */
class BitCoinFragment : BaseFragment() {
     var binding: FragmentBitcoinHistoricalBinding? = null
    private val viewModel: HistoricalViewModel by viewModel()

   // val sharedViewModel: SharedViewModel by sharedViewModel()

    override fun getViewModel(): BaseViewModel {
        return viewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

      //  if(binding==null) {

            binding = FragmentBitcoinHistoricalBinding
                .inflate(inflater, container, false)


            binding?.let {
                it.lifecycleOwner = viewLifecycleOwner
                it.adapter =
                    BitCoinHistoricalAdapter()
            }

            obse()

        //}

        return binding?.root

    }

    fun currency(name:String){
        viewModel.getHistoricalData(name)
    }


    fun obse() {



        viewModel.data.observe(this, Observer {
            binding?.adapter?.update(it)
        })

    }


}
