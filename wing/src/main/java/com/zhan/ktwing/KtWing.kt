package com.zhan.ktwing

import android.content.Context
import com.zhan.ktwing.delegate.Preference

/**
 *  @author: HyJame
 *  @date:   2019-09-25
 *  @desc:   KtWing 初始化
 */
object KtWing {

    fun init(context: Context) {
        Preference.init(context)
    }
}