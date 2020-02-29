package com.lalitp.zomatoapp.injection.component


import com.lalitp.zomatoapp.injection.module.NetworkModule
import com.lalitp.zomatoapp.viewmodel.ListItemViewModel
import com.lalitp.zomatoapp.viewmodel.ListViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {

    fun inject(listViewModel: ListViewModel)

    fun inject (listItemViewModel: ListItemViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}