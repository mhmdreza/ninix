package com.mhmdreza.ninix.utils

import android.graphics.Color
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.TextView
import com.mhmdreza.ninix.AlertType

fun createAlert(rootView: View, type: AlertType) {
    val snackbar = Snackbar.make(rootView, type.message, Snackbar.LENGTH_SHORT)
    val view = snackbar.view
    val textView = view.findViewById(android.support.design.R.id.snackbar_text) as TextView
    textView.setTextColor(Color.BLACK)
    view.setBackgroundColor(rootView.context.resources.getColor(type.colorId))
    snackbar.show()
}