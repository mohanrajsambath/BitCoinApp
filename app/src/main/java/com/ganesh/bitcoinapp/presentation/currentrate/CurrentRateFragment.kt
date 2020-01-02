package com.ganesh.bitcoinapp.presentation.currentrate


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.ganesh.bitcoinapp.databinding.FragmentBitcoinCurrentRateBinding
import com.ganesh.bitcoinapp.model.CurrentRateData
import com.ganesh.bitcoinapp.presentation.bitcoinhome.CurrencyInfoInterface
import com.ganesh.common.base.BaseFragment
import com.ganesh.common.base.BaseViewModel
import kotlinx.coroutines.*
import org.koin.android.viewmodel.ext.android.viewModel


/**
 * A simple [Fragment] subclass.
 */
class CurrentRateFragment : BaseFragment() {
    lateinit var binding: FragmentBitcoinCurrentRateBinding

    private val viewModel: CurrentRateViewModel by viewModel()
    var CanUpdateRates = false
    var currencyName: String = ""
    val timer: Long = 1000

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

        binding = FragmentBitcoinCurrentRateBinding
            .inflate(inflater, container, false)

        binding.apply {
            lifecycleOwner = viewLifecycleOwner
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        CanUpdateRates = true
        initThread()
    }


    /**
     *
     * to set currently selected currency name
     * @param name currency name
     */
    fun currency(name: String) {
        currencyName = name
    }


    fun initThread() {
        GlobalScope.launch(Dispatchers.Main) {
            refreshThread()
        }
    }


    /**
     * fetching current rate from server or cache in time intervel
     */
    suspend fun refreshThread() = withContext(Dispatchers.Main) {

        while (CanUpdateRates) {
            delay(timer)
            viewModel.getHistoricalData(currencyName)
        }

    }


    /**
     * init all observer of viewModel's liveData
     */
    fun setUpObserver() {

        viewModel.data.observe(this, Observer {
            binding.model = it
        })

        viewModel.errorMessage.observe(this, Observer {
            binding.model = CurrentRateData("", "", "")
        })

    }

}
