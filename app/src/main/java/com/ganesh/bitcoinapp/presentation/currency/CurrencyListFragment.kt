package com.ganesh.bitcoinapp.presentation.currency

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.ganesh.bitcoinapp.databinding.FragmentCurrencyListLayoutBinding
import com.ganesh.bitcoinapp.presentation.SharedViewModel
import com.ganesh.bitcoinapp.util.OnItemClickListener
import com.ganesh.bitcoinapp.util.addOnItemClickListener
import com.ganesh.common.base.BaseFragment
import com.ganesh.common.base.BaseViewModel
import com.ganesh.common2.extension.showSnackbar
import com.google.android.material.snackbar.Snackbar
import org.koin.android.viewmodel.ext.android.sharedViewModel
import org.koin.android.viewmodel.ext.android.viewModel


/**
 * A simple  subclass.
 */
class CurrencyListFragment : BaseFragment() {

    private val viewModel: CurrencyViewModel by viewModel()
    private val currencyListAdapter: CurrencyListAdapter = CurrencyListAdapter()
    val model: SharedViewModel by sharedViewModel()
    private lateinit var binding: FragmentCurrencyListLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCurrencyListLayoutBinding
            .inflate(inflater, container, false)

        binding.let {
            it.adapter = currencyListAdapter
            return it.root
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureRecyclerView()
        setUpViewModelObserver()
        loadCurrencyData()
    }

    override fun getViewModel(): BaseViewModel = viewModel

    private fun loadCurrencyData() =
        viewModel.getCurrencyList()

    private fun setUpViewModelObserver() {

        viewModel.currencyData().run {
            observe(this@CurrencyListFragment, Observer {
                currencyListAdapter.update(it)
            })
        }

        viewModel.errorMessage.observe(this, Observer {
            showSnackbar(it, Snackbar.LENGTH_SHORT)
        })

        viewModel.showProgressView.observe(this, Observer {
                binding.visibilities = it
        })

    }

    private fun configureRecyclerView() {

        binding.rcrCurrencyList.addOnItemClickListener(object : OnItemClickListener {
            override fun onItemClicked(position: Int, view: View) {

                viewModel.currencyData().value?.let { it ->
                    model.setCurrencyName(it[position].currnecyName)
                }.also {
                    findNavController().popBackStack()
                }
            }
        })
    }

}
