package com.edurda77.dictionary.view

import android.app.Application
import android.content.Context
import com.edurda77.dictionary.model.datasource.CaseRepo
import com.edurda77.dictionary.model.datasource.CaseRepoImpl
import com.edurda77.dictionary.presenter.BasePresenter
import com.edurda77.dictionary.presenter.Presenter

class App : Application() {
    val caseRepoImpl: CaseRepo by lazy { CaseRepoImpl() }
    //val presenterMainActivity:BasePresenter by lazy { Presenter(CaseRepoImpl(), this) }
    lateinit var presenterMainActivity: Presenter
    override fun onCreate() {
        super.onCreate()
        instance=this
        presenterMainActivity = Presenter(CaseRepoImpl(), this)
    }
    companion object {
        lateinit var instance:App
        private set
    }
}

val Context.app
    get() = applicationContext as App