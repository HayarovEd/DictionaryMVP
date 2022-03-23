package com.edurda77.dictionary.presenter

import com.edurda77.dictionary.view.BaseMainActivity

interface BasePresenter {
    fun attachView(view: BaseMainActivity)
    fun detachView(view: BaseMainActivity)
    fun getData(searchWord: String)

}