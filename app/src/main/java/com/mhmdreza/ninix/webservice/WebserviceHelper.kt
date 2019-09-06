package com.mhmdreza.ninix.webservice

import com.mhmdreza.ninix.webservice.webservices.login.LoginProcess
import com.mhmdreza.ninix.webservice.base.WebserviceException
import com.mhmdreza.ninix.webservice.webservices.login.LoginResponse
import java.io.IOException

object WebserviceHelper {

    @Throws(IOException::class, WebserviceException::class)
    fun login(phoneNumber: String = ""): LoginResponse = LoginProcess(phoneNumber).process()
}
