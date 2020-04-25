package com.zhan.hy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zhan.ktwing.delegate.Preference
import com.zhan.ktwing.ext.Toasts
import com.zhan.ktwing.ext.Toasts.toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var name by Preference("username", "张三")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mBtnToast.setOnClickListener {
            toast(getString(R.string.toast))
        }

        mBtnAppToast.setOnClickListener {
            Toasts.show(getString(R.string.app_toast))
        }

        mBtnIntent.setOnClickListener {
            //startActivity<LoginActivity>()
            toast(name)
        }
    }
}