package com.amplemind.network

import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


fun createNetworkClient(baseUrl: String, debug: Boolean = false) =
    retrofitClient(baseUrl, httpClient(debug))

private fun httpClient(debug: Boolean): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
    val clientBuilder = OkHttpClient.Builder()
    if (debug) {
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        clientBuilder.addInterceptor(httpLoggingInterceptor)
        clientBuilder.networkInterceptors().add(netWorkInterceptor)
    }
    return clientBuilder.build()
}

val netWorkInterceptor = Interceptor { chain ->
    val request = chain.request().newBuilder().build()
    val response = chain.proceed(request)
    response
}

private fun gson() = GsonBuilder().setLenient().create()

private fun retrofitClient(baseUrl: String, httpClient: OkHttpClient): Retrofit =
    Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create(gson()))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

