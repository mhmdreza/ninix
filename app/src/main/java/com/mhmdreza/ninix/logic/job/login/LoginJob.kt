package com.mhmdreza.ninix.logic.job.login

import com.mhmdreza.ninix.logic.LOGIN
import com.mhmdreza.ninix.logic.job.BaseJob
import com.mhmdreza.ninix.webservice.WebserviceHelper
import org.greenrobot.eventbus.EventBus
import java.lang.Exception

class LoginJob : BaseJob() {
    override fun onRunJob(params: Params): Result {
        return try {
            WebserviceHelper.login(phoneNumber)
            EventBus.getDefault().post(OnLoginSuccessEvent())
            Result.SUCCESS
        }catch (e: Exception){
            EventBus.getDefault().post(OnLoginFailureEvent())
            Result.FAILURE
        }
    }

    companion object {

        private var phoneNumber = ""

        fun schedule(phoneNumber : String) {
            LoginJob.phoneNumber = phoneNumber
            scheduleImmediateJob(LOGIN)
        }
    }
}
