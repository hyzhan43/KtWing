package com.zhan.ktwing.provider

import android.app.Application
import android.content.Context
import com.zhan.ktwing.KtWing

/**
 *  author: HyJame
 *  date:   2019-12-04
 *  desc:   默认初始化 KtArmor, 并提供 全局 applicationContext
 */
object ContextProvider {

    lateinit var application: Application

    fun attachContext(context: Context?) {
        application = context as? Application ?: throw RuntimeException("init KtWing error !")

        // init KtWing
        KtWing.init(application)
    }
}