package com.zhan.hy

import android.app.Activity
import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import org.junit.Assert.assertEquals
import org.robolectric.shadows.ShadowToast

/**
 *  author: HyJame
 *  date:   2020-04-25
 *  desc:   单元测试 基本Base
 */
object BaseTest {

    /**
     *  是否显示 toast
     */
    fun onToast(activity: Activity, @StringRes msgRes: Int) {
        assertEquals(activity.getString(msgRes), ShadowToast.getTextOfLatestToast())
    }

    /**
     *  点击控件
     */
    fun onClick(activity: Activity, @IdRes idRes: Int) {
        val view = activity.findViewById<View>(idRes)
        view.performClick()
    }
}