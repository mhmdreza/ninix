package com.mhmdreza.ninix


enum class AlertType(val colorId: Int, val message: String) {
    INVALID_PHONE_NUMBER(R.color.yellow, "PLEASE ENTER CORRECT PHONE NUMBER!"),
    LOGIN_ERROR(R.color.red, "AN ERROR HAPPENED DURING LOG IN!"),
    LOGIN_SUCCESS(R.color.green,"YOU HAVE SUCCESSFULLY ENTERED TO APP!")
}