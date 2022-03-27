package com.edurda77.dictionary.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.edurda77.dictionary.R
import com.edurda77.dictionary.model.data.WordTranslate
import com.edurda77.dictionary.model.datasource.CaseRepoImpl
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(private val caseRepoImpl: CaseRepoImpl) :
    MainActivityViewModelContract.ViewModel() {
    //private val caseRepoImpl = CaseRepoImpl()
    override val liveData: MutableLiveData<List<WordTranslate>> =
        MutableLiveData<List<WordTranslate>>()

    override fun getData(searchWord: String, context: Context) {
        val loadingData = caseRepoImpl.getData(searchWord)
        loadingData.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(getObserver(context))
    }

    private fun getObserver(context: Context): DisposableObserver<List<WordTranslate>> {
        return object : DisposableObserver<List<WordTranslate>>() {
            override fun onNext(wordTranslate: List<WordTranslate>) {
                liveData.postValue(wordTranslate)
            }

            override fun onError(e: Throwable) {
                Toast.makeText(context, "${R.string.error} $e", Toast.LENGTH_SHORT).show()
            }

            override fun onComplete() {
                Toast.makeText(context, R.string.all_loading, Toast.LENGTH_SHORT).show()
            }

        }
    }
}