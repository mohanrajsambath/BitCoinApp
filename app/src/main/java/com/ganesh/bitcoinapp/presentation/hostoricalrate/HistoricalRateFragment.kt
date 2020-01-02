package com.ganesh.bitcoinapp.presentation.hostoricalrate


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.ganesh.bitcoinapp.databinding.FragmentBitcoinHistoricalBinding
import com.ganesh.bitcoinapp.presentation.bitcoinhome.CurrencyInfoInterface
import com.ganesh.common.base.BaseFragment
import com.ganesh.common.base.BaseViewModel
import com.ganesh.common.extension.showSnackbar
import com.google.android.material.snackbar.Snackbar
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 */
class HistoricalRateFragment : BaseFragment() {
    lateinit var binding: FragmentBitcoinHistoricalBinding
    private val viewModel: HistoricalViewModel by viewModel()

    override fun getViewModel(): BaseViewModel {
        return viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // collect default currency name from parent
        currency((parentFragment as CurrencyInfoInterface).getDefaultCurrencyName())
        setUpObserver()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentBitcoinHistoricalBinding
            .inflate(inflater, container, false)


        binding?.let {
            it.lifecycleOwner = viewLifecycleOwner
            it.adapter =
                HistoricalRateAdapter()
        }

        return binding.root
    }

    /**
     * assign currently selected Currency value
     *
     * @param name currency name
     */
    fun currency(name: String) {
        viewModel.getHistoricalData(name)
    }


    fun setUpObserver() {

        viewModel.data.observe(this, Observer {
            binding.adapter?.update(it)
            binding.recyclerViewVisibilites = true
        })

        viewModel.errorMessage.observe(this, Observer {
            binding.recyclerViewVisibilites = false
            showSnackbar(it, Snackbar.LENGTH_LONG)
        })

        viewModel.showProgressView.observe(this, Observer {
            binding.progressVisibilites = it
        })

    }
}
