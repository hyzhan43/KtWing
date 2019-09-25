package com.zhan.ktwing

import android.content.Context
import com.zhan.ktwing.common.Preference
import com.zhan.ktwing.ext.Toasts

/**
 *  @author: HyJame
 *  @date:   2019-09-25
 *  @desc:   KtWing 初始化
 */
object KtWing{

    fun init(context: Context){

        Toasts.init(context)

        Preference.init(context)
    }
}