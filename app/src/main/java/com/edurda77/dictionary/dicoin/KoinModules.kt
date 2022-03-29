package com.edurda77.dictionary.dicoin

import com.edurda77.dictionary.model.data.BASE_URL
import com.edurda77.dictionary.model.datasource.ApiService
import com.edurda77.dictionary.model.datasource.CaseRepo
import com.edurda77.dictionary.model.datasource.CaseRepoImpl
import com.edurda77.dictionary.viewmodel.MainActivityViewModel
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }
    single<ApiService> (named("api")){
        get<Retrofit>().create(ApiService::class.java)
    }
    single<CaseRepo> (named("repo")) {
        CaseRepoImpl(get((named("api"))))
    }

    viewModel { MainActivityViewModel(caseRepoImpl = get((named("repo")))) }
}