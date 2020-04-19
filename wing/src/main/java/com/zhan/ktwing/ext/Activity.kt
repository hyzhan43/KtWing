package com.zhan.ktwing.ext

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.zhan.ktwing.utils.IntentUtils

/**
 * author：  HyJame
 * create：  2019/8/1
 * desc：    activity 扩展方法
 */

/**
 *  启动 Activity
 */
inline fun <reified T : Activity> Context.startActivity(vararg params: Pair<String, Any?>) {
    val intent = Intent(this, T::class.java)
    if (params.isNotEmpty()) IntentUtils.fillIntentArguments(intent, params)
    this.startActivity(intent)
}

/**
 * 启动 Activity, 并且 finish
 */
inline fun <reified T : Activity> Activity.startActivityAndFinish(vararg params: Pair<String, Any?>) {
    this.startActivity<T>(*params)
    this.finish()
}

inline fun <reified T : Activity> Fragment.startActivity(vararg params: Pair<String, Any?>) {
    val intent = Intent(context, T::class.java)
    if (params.isNotEmpty()) IntentUtils.fillIntentArguments(intent, params)
    activity?.startActivity(intent)
}
