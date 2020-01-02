package com.ganesh.bitcoinapp.presentation.bitcoinhome


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
import com.ganesh.bitcoinapp.presentation.hostoricalrate.HistoricalRateFragment
import com.ganesh.bitcoinapp.presentation.hostoricalrate.HistoricalViewModel
import com.ganesh.common.base.BaseFragment
import com.ganesh.common.base.BaseViewModel
import org.koin.android.viewmodel.ext.android.sharedViewModel
import org.koin.android.viewmodel.ext.android.viewModel


/**
 * A simple [Fragment] subclass.
 */
class BitCoinHomFragment : BaseFragment(), CurrencyInfoInterface {
    val rateFragmentTag = "currentRateFragment"
    val histroricalFragmentTag = "historicalRateFragment"
    var defaultName = "EUR"

    lateinit var binding: FragmentBitcoinDetailsBinding

    private val viewModel: HistoricalViewModel by viewModel()

    val sharedViewModel: SharedViewModel by sharedViewModel<SharedViewModel>()

    override fun getViewModel(): BaseViewModel {
        return viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpObserver()
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


    /**
     * load child fragments
     *
     */
    fun loadChildFragments() {

        val historicalFragment =
            HistoricalRateFragment()

        val currentRateFragment =
            CurrentRateFragment()

        childFragmentManager.beginTransaction().apply {
            add(R.id.frm_current_fragment, currentRateFragment, rateFragmentTag)
            add(R.id.frm_historical, historicalFragment, histroricalFragmentTag)
            commit()
        }

    }


    /**
     * update currency value to both fragment 1. current rate fragment 2. historical fragment
     *
     * @param currencyName
     */
    fun updateCurrencyValue(currencyName: String) {

        childFragmentManager.apply {
            val currentRateFragment =
                findFragmentByTag(rateFragmentTag) as CurrentRateFragment
            currentRateFragment.currency(currencyName)

            val historicalFragment =
                findFragmentByTag(histroricalFragmentTag) as HistoricalRateFragment
            historicalFragment.currency(currencyName)

        }

        currencyNameToView(currencyName)

    }

    /**
     * update curreny value to view
     *
     * @param currencyName
     */
    fun currencyNameToView(currencyName: String) {
        binding?.btnCurrencyName?.text = currencyName
    }

}
