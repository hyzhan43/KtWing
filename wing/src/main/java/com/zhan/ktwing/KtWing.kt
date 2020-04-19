package com.zhan.ktwing

import android.app.Application
import com.zhan.ktwing.delegate.Preference
import com.zhan.ktwing.ext.Toasts

/**
 *  @author: HyJame
 *  @date:   2019-09-25
 *  @desc:   KtWing 初始化
 */
object KtWing {

    internal fun init(application: Application) {
        Preference.init(application)

        Toasts.init(application)
    }
}