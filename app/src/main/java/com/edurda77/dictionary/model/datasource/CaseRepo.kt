package com.edurda77.dictionary.model.datasource

import com.edurda77.dictionary.model.data.datasource.WordTranslate
import io.reactivex.Observable

interface CaseRepo {
    fun getData (searchWord:String): Observable<List<WordTranslate>>
}