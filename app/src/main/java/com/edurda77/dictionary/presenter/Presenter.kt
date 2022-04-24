
package com.edurda77.dictionary.presenter

import android.app.Activity
import android.content.Context
import android.widget.Toast
import com.edurda77.dictionary.R
import com.edurda77.dictionary.model.data.WordTranslate
import com.edurda77.dictionary.model.datasource.CaseRepoImpl
import com.edurda77.dictionary.view.BaseMainActivity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class Presenter(private val caseRepoImpl: CaseRepoImpl, private val context: Context) :
    BasePresenter {
    private var activity: BaseMainActivity? = null

    override fun attachView(view: BaseMainActivity) {
        this.activity = view
    }

    override fun detachView(view: BaseMainActivity) {
        activity = null
    }

    override fun getData(searchWord: String) {
        val loadingData = caseRepoImpl.getData(searchWord)
       /* loadingData.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(getObserver())*/

    }

    private fun getObserver(): DisposableObserver<List<WordTranslate>> {
        return object : DisposableObserver<List<WordTranslate>>() {
            override fun onNext(wordTranslate: List<WordTranslate>) {
                activity?.loadData(wordTranslate)
            }

            override fun onError(e: Throwable) {
                //print("${R.string.error} $e")
                Toast.makeText(context, "${R.string.error} $e", Toast.LENGTH_SHORT).show()
            }

            override fun onComplete() {
                //print(R.string.all_loading)
                Toast.makeText(context, R.string.all_loading, Toast.LENGTH_SHORT).show()
            }

        }
    }

}
