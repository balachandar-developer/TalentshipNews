package com.baladev.talentshipnews.base.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.baladev.talentshipnews.base.viewmodel.BaseViewModel

/**
 * Basic fragment that provides usage for [ViewModel].
 */
abstract class BaseFragment<Binding : ViewDataBinding, ViewModel : BaseViewModel<Navigation>, Navigation> :
    Fragment(), VMOwner<Binding, ViewModel> {

    /**
     * This field contains the activity's [ViewModel] after this activity has been created.
     * The access to this field is read-only.
     */
    lateinit var viewModel: ViewModel
        private set

    protected lateinit var binding: Binding
        private set

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = createViewModel()
        binding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false)
        binding.apply {
            setVariable(getModelId(), viewModel)
            lifecycleOwner = provideLifecycleOwner()
            onBindingCreated(this)
        }
        return binding.root
    }

    abstract fun navigate(navigation: Navigation)

    override fun provideLifecycleOwner(): LifecycleOwner = this

    override fun onBindingCreated(binding: Binding) = Unit
}

