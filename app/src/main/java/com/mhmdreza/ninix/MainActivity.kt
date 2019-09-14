package com.mhmdreza.ninix

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import com.mhmdreza.ninix.logic.job.login.LoginJob
import com.mhmdreza.ninix.logic.job.login.OnLoginFailureEvent
import com.mhmdreza.ninix.logic.job.login.OnLoginSuccessEvent
import com.mhmdreza.ninix.utils.*
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


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
            val countryPhoneCode = countryCodeEditText.text.toString()
            val phoneNumber = countryPhoneCode + editText.text.toString()
            if (isValidPhoneNumber(phoneNumber, countryPhoneCode)) {
                LoginJob.schedule(phoneNumber)
            } else {
                createAlert(rootLayout, AlertType.INVALID_PHONE_NUMBER)
            }
        }
        val country = getCurrentLocale(this).country
        flagImageView.countryCode = country
        countryCodeEditText.setText(getCountryPhoneCode(country).toString())
        countryCodeEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val countryCode = if (s.isNullOrEmpty()) "" else getCountryCode(s.toString().toInt())
                flagImageView.countryCode = countryCode

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
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
