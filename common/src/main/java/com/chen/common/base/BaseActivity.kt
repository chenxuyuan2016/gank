package com.chen.common.base

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.chen.common.base.presenter.PresenterDispatch
import com.chen.common.base.presenter.PresenterProviders

abstract class BaseActivity : AppCompatActivity(), BaseView {

    private var presenterDispatch: PresenterDispatch? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(layoutId())
        presenterDispatch = PresenterDispatch(PresenterProviders.inject(this))
                .apply {
                    onCreate(this@BaseActivity)
                }

        initData()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenterDispatch?.onDestroy()
    }

    abstract fun layoutId(): Int

    abstract fun initData()


}