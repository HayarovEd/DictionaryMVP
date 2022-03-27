package com.edurda77.dictionary.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.edurda77.dictionary.viewmodel.MainActivityViewModel
import com.edurda77.dictionary.viewmodel.MainActivityViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [RetrofitModule::class])

internal abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: MainActivityViewModelFactory):
            ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    protected abstract fun mainViewModel(mainViewModel: MainActivityViewModel): ViewModel
}
