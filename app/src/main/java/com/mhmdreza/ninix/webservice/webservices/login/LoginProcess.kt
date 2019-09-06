package com.mhmdreza.ninix.webservice.webservices.login

import com.mhmdreza.ninix.webservice.base.MyRetrofit
import com.mhmdreza.ninix.webservice.base.requestProcess.BaseProcess
import com.mhmdreza.ninix.webservice.base.WebserviceException
import java.io.IOException


class LoginProcess(private val phoneNumber: String) : BaseProcess() {


    @Throws(IOException::class, WebserviceException::class)
    override fun process(): LoginResponse {
        return send(MyRetrofit.webserviceUrls.login(phoneNumber))
    }
}
