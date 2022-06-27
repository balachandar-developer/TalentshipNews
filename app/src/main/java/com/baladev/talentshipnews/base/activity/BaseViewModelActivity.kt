package com.baladev.talentshipnews.base.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.baladev.talentshipnews.base.fragments.VMOwner

abstract class BaseViewModelActivity<Binding : ViewDataBinding, Model : ViewModel> :
    AppCompatActivity(), VMOwner<Binding, Model> {

    /**
     * This field contains the activity's [ViewModel] after this activity has been created.
     * The access to this field is read-only.
     */
    lateinit var viewModel: Model
        private set

    protected lateinit var binding: Binding
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = createViewModel()
        binding = DataBindingUtil.setContentView(this, getLayoutRes())
        binding.apply {
            setVariable(getModelId(), viewModel)
            lifecycleOwner = provideLifecycleOwner()
            onBindingCreated(this)
        }
    }

    override fun provideLifecycleOwner(): LifecycleOwner = this

    override fun onBindingCreated(binding: Binding) = Unit
}

