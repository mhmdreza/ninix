package com.mhmdreza.ninix

import android.app.Application
import android.content.Context
import com.evernote.android.job.JobManager
import com.mhmdreza.ninix.logic.MyJobCreator
import uk.co.chrisjenx.calligraphy.CalligraphyConfig

class ApplicationLoader : Application() {

    override fun onCreate() {
        super.onCreate()
        JobManager.create(this).addJobCreator(MyJobCreator())
        initFont()
        appContext = applicationContext
    }

    private fun initFont() {
        CalligraphyConfig.initDefault(CalligraphyConfig.Builder()
            .setDefaultFontPath("fonts/exo_regular.ttf")
            .setFontAttrId(R.attr.fontPath)
            .build())
    }

    companion object {
        var appContext: Context? = null
            private set
    }
}
