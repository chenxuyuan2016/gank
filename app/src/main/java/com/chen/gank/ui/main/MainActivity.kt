package com.chen.gank.ui.main

import com.chen.common.annotation.PresenterCreate
import com.chen.common.annotation.PresenterSet
import com.chen.common.base.BaseActivity
import com.chen.gank.R
import com.chen.gank.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

@PresenterCreate(
        kClass = [
            MainPresenter::class
        ]
)
class MainActivity : BaseActivity() {

    @PresenterSet
    private var mainPresenter: MainPresenter? = null

    override fun layoutId(): Int = R.layout.activity_main

    override fun initData() {
        initTitle()
        mainPresenter?.requestTodayFromNet()

    }

    private fun initTitle() {
        //setSupportActionBar(tb_today)
        //tb_today.setTitleTextColor(resources.getColor(R.color.color_FFFFFF))
    }


}
