package com.edurda77.dictionary.presenter

import android.content.Context
import android.widget.Toast
import com.edurda77.dictionary.model.data.datasource.WordTranslate
import com.edurda77.dictionary.model.datasource.CaseRepoImpl
import com.edurda77.dictionary.view.BaseMainActivity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers

class Presenter(private val caseRepoImpl: CaseRepoImpl, private val context:Context):BasePresenter {
    private var activity: BaseMainActivity? = null
    private var dataInput = emptyList<WordTranslate>().toMutableList()
    override fun attachView(view: BaseMainActivity) {
        this.activity=view
    }

    override fun detachView(view: BaseMainActivity) {
        activity=null
    }

    override fun getData(searchWord: String) {
        dataInput.clear()
        val loadnigData = caseRepoImpl.getData(searchWord)
        loadnigData.subscribeOn(Schedulers.newThread())
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .map { it }
            .subscribeBy(
                onError = {
                    Toast.makeText(context, "Ошибка $it", Toast.LENGTH_SHORT).show()
                },
                onNext = { list ->
                    list.forEach {
                        dataInput.add(it)
                    }
                },
                onComplete = {
                    Toast.makeText(context, "Все загружено", Toast.LENGTH_SHORT).show()
                })
        activity?.loadData(dataInput)
    }

}