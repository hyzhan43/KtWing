package com.zhan.ktwing.ext

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Build
import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

/**
 * @author  hyzhan
 * @date    2019/5/22
 * @desc    Toast 扩展函数
 */
object Toasts {

    // 局部toast
    private var mToast: Toast? = null

    // 全局toast
    private var appToast: Toast? = null

    private lateinit var application: Application

    /**
     *  初始化 application 级别 toast
     */
    @SuppressLint("ShowToast")
    fun init(application: Application) {
        this.application = application
        appToast = Toast.makeText(application, "", Toast.LENGTH_SHORT)
    }

    /**
     *  application级别 toast
     */
    fun show(message: String) {
        // 兼容 Android 9.0 toast 显示问题(只会显示一次问题)
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.P) {
            Toast.makeText(application, message, Toast.LENGTH_SHORT).show()
            return
        }

        appToast?.apply { setText(message) }?.show()
    }

    /**
     *  防止重复 showToast 显示
     *  如果 mToast不为空 就显示, 否则就创建新的 mToast
     */
    private fun <T : Context> showToast(context: T, message: String, duration: Int) {

        // 兼容 Android 9.0 toast 显示一次问题
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.P) {
            Toast.makeText(context, message, duration).show()
            return
        }

        (getCacheToast(duration, message) ?: newToast(context, message, duration)).show()
    }

    private fun getCacheToast(duration: Int, message: String): Toast? {
        return mToast?.apply {
            this.duration = duration
            setText(message)
        }
    }

    private fun <T : Context> newToast(context: T, message: String, duration: Int): Toast {
        return Toast.makeText(context.applicationContext, message, duration).apply { mToast = this }
    }

    fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
        showToast(this, message, duration)
    }

    fun Context.toast(@StringRes message: Int, duration: Int = Toast.LENGTH_SHORT) {
        toast(getString(message), duration)
    }

    fun Activity.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
        showToast(this, message, duration)
    }

    fun Activity.toast(@StringRes message: Int, duration: Int = Toast.LENGTH_SHORT) {
        toast(getString(message), duration)
    }

    fun Fragment.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
        context?.let { showToast(it, message, duration) }
    }

    fun Fragment.toast(@StringRes strRes: Int, duration: Int = Toast.LENGTH_SHORT) {
        toast(getString(strRes), duration)
    }

    fun View.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
        context?.let { showToast(it, message, duration) }
    }

    fun View.toast(@StringRes strRes: Int, duration: Int = Toast.LENGTH_SHORT) {
        toast(context.getString(strRes), duration)
    }
}