package com.mhmdreza.ninix.utils

fun isValidPhoneNumber(fullNumber: String, countryPhoneCode: String): Boolean {
    return if (fullNumber.length < 10 || fullNumber.length > 13) {
        false
    } else isValidCountryPhoneCode(countryPhoneCode)
}