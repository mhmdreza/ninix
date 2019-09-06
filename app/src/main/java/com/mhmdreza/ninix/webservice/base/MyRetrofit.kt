package com.mhmdreza.ninix.webservice.base

import com.google.gson.GsonBuilder
import com.mhmdreza.ninix.webservice.base.constants.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MyRetrofit {

    var webserviceUrls = getUrls()
    private fun getUrls(): WebserviceUrls {
        val gson = GsonBuilder()
            .setLenient()
            .create()
        val builder = OkHttpClient.Builder()
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        builder.addInterceptor(interceptor)
        val client = builder.build()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
        return retrofit.create(WebserviceUrls::class.java)
    }
}
