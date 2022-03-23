package com.edurda77.dictionary.model.datasource

import com.edurda77.dictionary.model.data.WordTranslate
import io.reactivex.rxjava3.core.Observable


interface CaseRepo {
    fun getData (searchWord:String): Observable<List<WordTranslate>>
}