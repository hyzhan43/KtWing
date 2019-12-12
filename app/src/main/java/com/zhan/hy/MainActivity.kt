package com.zhan.hy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zhan.ktwing.ext.Toasts.toast
import com.zhan.ktwing.ext.setDoubleClickListener
import com.zhan.ktwing.ext.setTripleClickListener
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mBtnHello.setTripleClickListener {
            toast("Hello World")
        }
    }
}