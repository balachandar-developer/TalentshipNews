package com.baladev.talentshipnews.base.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baladev.talentshipnews.util.SingleLiveEvent
import com.baladev.talentshipnews.util.withLoading
import kotlinx.coroutines.launch

abstract class BaseViewModel<Navigation> : ViewModel() {
    val navigation: SingleLiveEvent<Navigation> = SingleLiveEvent()
    val loading: MutableLiveData<Boolean> = MutableLiveData(false)
    val refreshing: MutableLiveData<Boolean> = MutableLiveData(false)

    fun launchLoading() {
        launchWithLoading(loading, this::reloadData)
    }

    fun launchRefresh() {
        launchWithLoading(refreshing, this::reloadData)
    }

    fun launchWithLoading(loading: MutableLiveData<Boolean> = this.loading, work: suspend () -> Unit) {
        viewModelScope.launch {
            loading.withLoading(work)
        }
    }

    abstract suspend fun reloadData()
}
