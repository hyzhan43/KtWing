package com.zhan.hy

import android.os.Build
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.zhan.hy.BaseTest.onClick
import com.zhan.hy.BaseTest.onToast
import com.zhan.ktwing.ext.Toasts
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config


/**
 *  author: HyJame
 *  date:   2020/4/25
 *  desc:   TODO
 */
@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.Q])
class ToastTest {

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setUp() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun test_toast_show() {
        scenario.onActivity {
            onClick(it, R.id.mBtnToast)
            onToast(it, R.string.toast)
        }
    }

    @Test
    fun show_app_toast() {
        scenario.onActivity {
            Toasts.init(it.application)
            onClick(it, R.id.mBtnAppToast)
            onToast(it, R.string.app_toast)
        }
    }


}