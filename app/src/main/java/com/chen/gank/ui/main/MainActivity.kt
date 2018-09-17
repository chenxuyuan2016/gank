package com.chen.gank.ui.main

import com.chen.common.annotation.CreatePresenter
import com.chen.common.annotation.PresenterVariable
import com.chen.common.base.BaseActivity
import com.chen.gank.R
import com.chen.gank.presenter.MainPresenter

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


}
