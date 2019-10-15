package com.zhan.ktwing.ext

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import com.zhan.ktwing.utils.ClickUtil

/**
 * @author  hyzhan
 * @date    2019/5/23
 * @desc    TODO
 */
// 关闭软键盘
fun View.hideKeyboard() {
    val imm: InputMethodManager =
        context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(this.windowToken, 0)
}

// 显示软键盘
fun View.showKeyboard() {
    val imm: InputMethodManager =
        context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    this.requestFocus()
    imm.showSoftInput(this, 0)
}

// 关闭软键盘
fun Activity.hideKeyboard() {
    // 当前焦点的 View
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
}

// 获取text内容
fun TextView.str(): String {
    return this.text.toString()
}

// 设置双击事件
fun View.setDoubleClickListener(block: () -> Unit) {
    this.setOnClickListener { ClickUtil.interval(block) }
}


fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.isVisible(): Boolean = this.visibility == View.VISIBLE

fun View.isInvisible(): Boolean = this.visibility == View.INVISIBLE

fun View.isGone(): Boolean = this.visibility == View.GONE