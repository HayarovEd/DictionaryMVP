/*
package com.edurda77.dictionary.di

import com.edurda77.dictionary.model.data.BASE_URL
import com.edurda77.dictionary.model.datasource.ApiService
import dagger.Module
import dagger.Provides
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitModule {
    @Provides
    @Singleton
    internal fun getRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()

    @Provides
    @Singleton
    internal fun getApi(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)
}*/
