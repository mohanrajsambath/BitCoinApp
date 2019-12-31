package com.ganesh.bitcoinapp.presentation.bitcoin


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.ganesh.bitcoinapp.R
import com.ganesh.bitcoinapp.databinding.FragmentBitcoinDetailsBinding
import com.ganesh.bitcoinapp.presentation.SharedViewModel
import com.ganesh.bitcoinapp.presentation.currentrate.CurrentRateFragment
import com.ganesh.bitcoinapp.presentation.hostoricalrate.BitCoinHistoricalFragment
import com.ganesh.bitcoinapp.presentation.hostoricalrate.HistoricalViewModel
import com.ganesh.common.base.BaseFragment
import com.ganesh.common.base.BaseViewModel
import org.koin.android.viewmodel.ext.android.sharedViewModel
import org.koin.android.viewmodel.ext.android.viewModel


/**
 * A simple [Fragment] subclass.
 */
class BitCoinDetailsFragment : BaseFragment(), CurrencyInfoInterface {
    val rateFragmentTag = "currentRateFragment"
    val histroricalFragmentTag = "historicalRateFragment"
    var defaultName = "EUR"

    lateinit var binding: FragmentBitcoinDetailsBinding

    private val viewModel: HistoricalViewModel by viewModel()

    val sharedViewModel: SharedViewModel by sharedViewModel<SharedViewModel>()

    override fun getViewModel(): BaseViewModel {
        return viewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        if (!::binding.isInitialized) {

            binding = FragmentBitcoinDetailsBinding
                .inflate(inflater, container, false)

            loadChildFragments()

            binding.apply {
                lifecycleOwner = viewLifecycleOwner
                bitCoinViewModel = viewModel

            }

            currencyNameToView(defaultName)
            setUpObserver()
        }

        return binding.root

    }

    override fun getDefaultCurrencyName(): String {
        return defaultName
    }


    fun setUpObserver() {
        sharedViewModel.get().observe(this, Observer {
            updateCurrencyValue(it)
        })
    }


    fun loadChildFragments() {
        val historicalFragment =
            BitCoinHistoricalFragment()
        val currentRateFragment =
            CurrentRateFragment()

        childFragmentManager.beginTransaction().apply {
            add(R.id.frm_current_fragment, currentRateFragment, rateFragmentTag)
            add(R.id.frm_historical, historicalFragment, histroricalFragmentTag)
            commit()
        }

    }


    fun updateCurrencyValue(currencyName: String) {

        childFragmentManager.apply {
            val currentRateFragment =
                findFragmentByTag(rateFragmentTag) as CurrentRateFragment
            currentRateFragment.currency(currencyName)

            val historicalFragment =
                findFragmentByTag(histroricalFragmentTag) as BitCoinHistoricalFragment
            historicalFragment.currency(currencyName)

        }

        currencyNameToView(currencyName)

    }

    fun currencyNameToView(currencyName: String) {
        binding?.btnCurrencyName?.text = currencyName
    }


}
