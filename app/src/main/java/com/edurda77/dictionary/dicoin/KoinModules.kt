package com.edurda77.dictionary.dicoin

import com.edurda77.dictionary.model.data.BASE_URL
import com.edurda77.dictionary.model.datasource.ApiService
import com.edurda77.dictionary.model.datasource.CaseRepoImpl
import com.edurda77.dictionary.viewmodel.MainActivityViewModel
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val viewModelModule = module {
    viewModel { MainActivityViewModel(get()) }
}
val apiModule = module {
    fun provideUserApi(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
    single { provideUserApi(get()) }
}
val netModule = module {
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            //.addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }
    single { provideRetrofit() }
}
val repositoryModule = module {
    fun provideUserRepository(api: ApiService): CaseRepoImpl {
        return CaseRepoImpl(api)
    }
    single { provideUserRepository(get()) }
}