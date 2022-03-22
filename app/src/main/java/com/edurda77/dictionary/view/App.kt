package com.edurda77.dictionary.view

import android.app.Application
import android.content.Context
import com.edurda77.dictionary.model.datasource.CaseRepo
import com.edurda77.dictionary.model.datasource.CaseRepoImpl

class App : Application() {
    val caseRepoImpl: CaseRepo by lazy { CaseRepoImpl() }
}

val Context.app
    get() = applicationContext as App