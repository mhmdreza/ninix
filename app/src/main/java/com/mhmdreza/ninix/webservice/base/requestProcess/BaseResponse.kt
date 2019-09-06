package com.mhmdreza.ninix.webservice.base.requestProcess

import com.google.gson.annotations.Expose

open class BaseResponse {
    @Expose
    var messageBody: String? = null
}
