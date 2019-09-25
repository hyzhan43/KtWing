package com.zhan.ktwing.utils

/**
 * author：  HyZhan
 * create：  2019/8/13
 * desc：    TODO
 */
object ClickUtil {

    private var clickTime: Long = 0

    /**
     *  双击事件
     *  @param duration 两次间隔时间
     */
    fun interval(block: () -> Unit, duration: Int = 1000) {
        val nowTime = System.currentTimeMillis()
        if (nowTime - clickTime > duration) {
            clickTime = nowTime
        } else {
            block()
        }
    }
}