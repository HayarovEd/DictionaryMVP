package com.edurda77.dictionary

import android.app.Application
import com.edurda77.dictionary.model.datasource.CaseRepoImpl
import com.edurda77.dictionary.presenter.Presenter

/*class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(viewModelModule, apiModule, netModule, repositoryModule))
        }
    }

}*/
/* Dagger - class App : Application(), HasAndroidInjector{
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
} */
class App : Application() {
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
}
