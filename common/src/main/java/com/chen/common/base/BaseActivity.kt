package com.chen.common.base

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.chen.common.extend.Extend.toastShow
import com.chen.common.base.presenter.PresenterManager
import com.chen.common.base.presenter.PresenterProviders

abstract class BaseActivity : AppCompatActivity(), BaseView {

    private var presenterManager: PresenterManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(layoutId())
        presenterManager = PresenterManager(PresenterProviders.inject(this))
                .apply {
                    onPresenterCreate(this@BaseActivity)
                }
        initData()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenterManager?.onPresenterDestroy()
    }

    abstract fun layoutId(): Int

    abstract fun initData()

    override fun toast(msg: String) = toastShow(msg)

}