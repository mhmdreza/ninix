package com.mhmdreza.ninix

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mhmdreza.ninix.logic.job.login.LoginJob
import com.mhmdreza.ninix.logic.job.login.OnLoginFailureEvent
import com.mhmdreza.ninix.logic.job.login.OnLoginSuccessEvent
import com.mhmdreza.ninix.utils.createAlert
import com.mhmdreza.ninix.utils.hideKeyboard
import com.mhmdreza.ninix.utils.isValidPhoneNumber
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


const val PHONE_NUMBER_SIZE = 10

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        EventBus.getDefault().register(this)
        initViews()
    }

    private fun initViews() {
        rootLayout.setOnTouchListener(object : OnSwipeTouchListener(this) {
            override fun onSwipeTop() {
                hideKeyboard(this@MainActivity)
            }
        })
        confirmButton.setOnClickListener {
            if (isValidPhoneNumber(editText.text.toString())) {
                LoginJob.schedule("98${editText.text}")
            } else {
                createAlert(rootLayout, AlertType.INVALID_PHONE_NUMBER)
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: OnLoginSuccessEvent) {
        createAlert(rootLayout, AlertType.LOGIN_SUCCESS)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: OnLoginFailureEvent) {
        createAlert(rootLayout, AlertType.LOGIN_ERROR)
    }


    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }
}
