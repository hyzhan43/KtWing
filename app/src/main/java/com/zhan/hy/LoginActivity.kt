package com.zhan.hy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zhan.ktwing.ext.str
import kotlinx.android.synthetic.main.activity_login.*

/**
 *  author: HyJame
 *  date:   2019-12-30
 *  desc:   TODO
 */
class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initView()
        initListener()
    }


    private fun initView() {
    }

    private fun initListener() {
        mBtnLogin.setOnClickListener {
        }
    }

}
