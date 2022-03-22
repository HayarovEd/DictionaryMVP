package com.edurda77.dictionary.model.datasource

import com.edurda77.dictionary.model.data.datasource.WordTranslate
import io.reactivex.rxjava3.core.Observable

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("words/search")
    fun search(@Query("search") wordToSearch: String): Observable<List<WordTranslate>>
}