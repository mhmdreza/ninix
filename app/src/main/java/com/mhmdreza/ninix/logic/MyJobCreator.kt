package com.mhmdreza.ninix.logic

import com.evernote.android.job.Job
import com.evernote.android.job.JobCreator
import com.mhmdreza.ninix.logic.job.login.LoginJob

const val LOGIN = "LOGIN"

class MyJobCreator : JobCreator {

    override fun create(s: String): Job? {
        return when (s) {
            LOGIN -> LoginJob()
            else -> null
        }
    }
}
