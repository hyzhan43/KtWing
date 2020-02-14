package com.zhan.ktwing.delegate

import android.app.Activity
import android.os.Bundle
import android.os.Parcelable
import java.io.Serializable
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 *  author: HyJame
 *  date:   2019-12-30
 *  desc:   intent extra 封装的代理类
 */
class Intent<T>(val name: String, private val default: T) :
    ReadWriteProperty<Activity?, T> {

    override fun getValue(thisRef: Activity?, property: KProperty<*>): T = findPreference(thisRef)

    override fun setValue(thisRef: Activity?, property: KProperty<*>, value: T) {
        putPreference(thisRef, value)
    }

    @Suppress("UNCHECKED_CAST")
    private fun findPreference(thisRef: Activity?): T {
        return thisRef?.intent?.run {
            val res: Any = when (default) {
                is Long -> getLongExtra(name, default)
                is String -> getStringExtra(name) ?: default
                is CharSequence -> getCharSequenceExtra(name)
                is Int -> getIntExtra(name, default)
                is Boolean -> getBooleanExtra(name, default)
                is Float -> getFloatExtra(name, default)
                is Parcelable -> getParcelableExtra(name)
                is Double -> getDoubleExtra(name, default)
                is Char -> getCharExtra(name, default)
                is Short -> getShortExtra(name, default)
                is Serializable -> getSerializableExtra(name)
                is Bundle -> getBundleExtra(name)
                is Array<*> -> when {
                    default.isArrayOf<CharSequence>() -> getCharSequenceArrayExtra(name)
                    default.isArrayOf<String>() -> getStringArrayExtra(name)
                    default.isArrayOf<Parcelable>() -> getParcelableArrayExtra(name)
                    else -> throw Exception("Intent extra $name has wrong type ${default.javaClass.name}")
                }
                is IntArray -> getIntArrayExtra(name)
                is LongArray -> getLongArrayExtra(name)
                is FloatArray -> getFloatArrayExtra(name)
                is DoubleArray -> getDoubleArrayExtra(name)
                is CharArray -> getCharArrayExtra(name)
                is ShortArray -> getShortArrayExtra(name)
                is BooleanArray -> getBooleanArrayExtra(name)
                else -> throw Exception("Intent extra $name has wrong type")
            }
            res as T
        } ?: throw IllegalArgumentException("This activity can be get intent")
    }

    private fun <T> putPreference(activity: Activity?, value: T) {
        activity?.intent?.run {
            when (value) {
                is Double -> putExtra(name, value)
                is Char -> putExtra(name, value)
                is Short -> putExtra(name, value)
                is Long -> putExtra(name, value)
                is String -> putExtra(name, value)
                is CharSequence -> putExtra(name, value)
                is Int -> putExtra(name, value)
                is Boolean -> putExtra(name, value)
                is Float -> putExtra(name, value)
                is Parcelable -> putExtra(name, value)
                is Serializable -> putExtra(name, value)
                is Bundle -> putExtra(name, value)
                is Array<*> -> when {
                    value.isArrayOf<CharSequence>() -> putExtra(name, value)
                    value.isArrayOf<String>() -> putExtra(name, value)
                    value.isArrayOf<Parcelable>() -> putExtra(name, value)
                    else -> throw Exception("Intent extra $name has wrong type ${value.javaClass.name}")
                }
                is IntArray -> putExtra(name, value)
                is LongArray -> putExtra(name, value)
                is FloatArray -> putExtra(name, value)
                is DoubleArray -> putExtra(name, value)
                is CharArray -> putExtra(name, value)
                is ShortArray -> putExtra(name, value)
                is BooleanArray -> putExtra(name, value)
                else -> throw Exception("Intent extra $name has wrong type")
            }
        }
    }
}