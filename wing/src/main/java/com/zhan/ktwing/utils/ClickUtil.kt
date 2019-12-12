package com.zhan.ktwing.utils

/**
 * author：  HyZhan
 * create：  2019/8/13
 * desc：    TODO
 */
object ClickUtil {

    private var clickTime: Long = 0

    private var frequency = 1

    /**
     *  双击事件
     *  @param duration 两次间隔时间
     */
    fun interval(count: Int = 2, duration: Int = 1000, block: () -> Unit) {
        val nowTime = System.currentTimeMillis()

        if (nowTime - clickTime > duration) {
            clickTime = nowTime
            frequency = 1
            return
        }

        frequency++

        if (frequency != count) return

        block()
        frequency = 1
    }
}