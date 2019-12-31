package com.ganesh.common.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.ganesh.common.utils.NavigationCommand
import com.ganesh.common2.utils.Event


abstract class BaseViewModel : ViewModel() {

    // FOR ERROR HANDLER
    protected val _snackbarError = MutableLiveData<Event<Int>>()
    val snackBarError: LiveData<Event<Int>> get() = _snackbarError

    //ERROR message
    val errorMessage: MutableLiveData<String> = MutableLiveData()

    // progress indicator
    //ERROR message
    val showProgressView: MutableLiveData<Boolean> = MutableLiveData()

    // FOR NAVIGATION
    private val _navigation = MutableLiveData<Event<NavigationCommand>>()
    val navigation: LiveData<Event<NavigationCommand>> = _navigation

    /**
     * Convenient method to handle navigation from a [ViewModel]
     */
    fun navigate(directions: NavDirections) {
        _navigation.value = Event(NavigationCommand.To(directions))
    }
}