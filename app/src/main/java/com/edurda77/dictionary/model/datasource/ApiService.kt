package com.edurda77.dictionary.model.datasource

import com.edurda77.dictionary.model.data.SEARCH
import com.edurda77.dictionary.model.data.WORD_SEARCH
import com.edurda77.dictionary.model.data.WordTranslate
import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.Deferred

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(WORD_SEARCH)
    //fun search(@Query(SEARCH) wordToSearch: String): Deferred<List<WordTranslate>>//coroutines
    fun search(@Query(SEARCH) wordToSearch: String): Observable<List<WordTranslate>>
}