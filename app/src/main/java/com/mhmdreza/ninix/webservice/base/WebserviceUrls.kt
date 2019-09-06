package com.mhmdreza.ninix.webservice.base

import com.mhmdreza.ninix.webservice.base.constants.LOGIN
import com.mhmdreza.ninix.webservice.webservices.login.LoginResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WebserviceUrls {
    @GET(LOGIN)
    fun login(@Query("mobile_number") phoneNumber: String): Call<LoginResponse>
}
