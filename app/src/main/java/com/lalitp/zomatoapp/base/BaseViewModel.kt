package com.lalitp.zomatoapp.base

import androidx.lifecycle.ViewModel
import com.lalitp.zomatoapp.injection.component.DaggerViewModelInjector
import com.lalitp.zomatoapp.injection.component.ViewModelInjector
import com.lalitp.zomatoapp.injection.module.NetworkModule
import com.lalitp.zomatoapp.viewmodel.ListItemViewModel
import com.lalitp.zomatoapp.viewmodel.ListViewModel


abstract class BaseViewModel : ViewModel() {
    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is ListViewModel -> injector.inject(this)
            is ListItemViewModel -> injector.inject(this)
        }
    }
}