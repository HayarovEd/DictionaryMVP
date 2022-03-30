package com.edurda77.dictionary.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.edurda77.dictionary.model.data.WordTranslate
import kotlinx.coroutines.*

interface MainActivityViewModelContract {
    abstract class ViewModel :androidx.lifecycle.ViewModel(){
        //abstract val liveData:LiveData<List<WordTranslate>> - without coroutines
        //->
        protected val viewModelCoroutineScope = CoroutineScope(
            Dispatchers.Main
                    + SupervisorJob()
                    + CoroutineExceptionHandler { _, throwable ->
                handleError(throwable)
            })
        override fun onCleared() {
            super.onCleared()
            cancelJob()
        }
        protected fun cancelJob() {
            viewModelCoroutineScope.coroutineContext.cancelChildren()
        }
        abstract fun handleError(error: Throwable)
        //<-coroutines
        abstract fun getData(searchWord: String)
    }

}