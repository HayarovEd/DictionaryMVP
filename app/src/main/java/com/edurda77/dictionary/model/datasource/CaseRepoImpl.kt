package com.edurda77.dictionary.model.datasource

import com.edurda77.dictionary.model.data.WordTranslate
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.core.Observable

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://dictionary.skyeng.ru/api/public/v1/"

class CaseRepoImpl : CaseRepo {
    private var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()
    private var api: ApiService = retrofit.create(ApiService::class.java)
    override fun getData(searchWord: String): Observable<List<WordTranslate>> {
        return api.search(searchWord)
    }
}