package com.edurda77.dictionary

import android.app.Application
import com.edurda77.dictionary.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App : Application(), HasAndroidInjector{
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>
    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }
    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }
} /*{
    lateinit var presenterMainActivity: Presenter
    override fun onCreate() {
        super.onCreate()
        instance = this
        presenterMainActivity = Presenter(CaseRepoImpl(), this)
    }

    companion object {
        lateinit var instance: App
            private set
    }
}*/
