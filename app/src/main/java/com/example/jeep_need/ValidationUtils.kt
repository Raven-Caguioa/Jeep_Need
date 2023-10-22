package com.example.jeep_need

import android.text.TextUtils

object ValidationUtils {
    fun isTextNotEmpty(text: String?): Boolean{
        return !TextUtils.isEmpty(text)
    }
}