package com.mhmdreza.ninix.utils

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager


fun hideKeyboard(activity: Activity) {
    // Check if no view has focus:
    try {
        val view = activity.currentFocus
        if (view != null) {
            val inputManager = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    } catch (e: Exception) {

    }
}