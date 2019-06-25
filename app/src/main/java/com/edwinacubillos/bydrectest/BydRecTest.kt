package com.edwinacubillos.bydrectest

import android.app.Application
import android.content.Context

class BydRecTest : Application() {

    private var mContext: Context? = null

    companion object {
        lateinit var mInstance: BydRecTest
        fun getInstance() = mInstance
    }

    override fun onCreate() {
        super.onCreate()
        setAppContext(this)
        mInstance = this
    }

    fun getContext(): Context? {
        return mContext
    }

    fun setAppContext(context: Context) {
        mContext = context
    }
}
