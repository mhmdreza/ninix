package com.mhmdreza.ninix.utils

import com.mhmdreza.ninix.PHONE_NUMBER_SIZE

fun isValidPhoneNumber(text: String): Boolean {
    if (text.length != PHONE_NUMBER_SIZE) return false
    text.forEach {
        if (it < '0' || it > '9') return false
    }
    return true
}