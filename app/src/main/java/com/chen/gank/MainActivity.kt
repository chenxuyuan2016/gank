package com.chen.gank

import com.chen.common.annotation.CreatePresenter
import com.chen.common.annotation.PresenterVariable
import com.chen.common.base.BaseActivity
import com.chen.gank.login.LoginPresenter
import com.chen.gank.login.LoginView
import com.chen.gank.register.RegisterPresenter
import com.chen.gank.login.RegisterView
import com.chen.util.ExpandUtil.toastShow

@CreatePresenter(
        kClass = [
            MainPresenter::class
        ]
)
class MainActivity : BaseActivity() {

    @PresenterVariable
    private var mainPresenter: MainPresenter? = null

    override fun layoutId(): Int = R.layout.activity_main

    override fun initData() {
        mainPresenter?.requestTodayFromNet()
    }

    override fun toast(msg: String) = toastShow(msg)

}
