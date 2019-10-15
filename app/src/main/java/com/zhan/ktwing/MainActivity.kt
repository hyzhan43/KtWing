package com.zhan.ktwing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zhan.ktwing.ext.tryCatch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        tryCatch {
            onTry {

            }

            onCatch {

            }
        }
    }
}