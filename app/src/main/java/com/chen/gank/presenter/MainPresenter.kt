package com.chen.gank.presenter

import com.chen.common.base.BasePresenter
import com.chen.common.base.BaseView
import com.chen.network.bean.TodayModel
import com.chen.network.client.ApiClient
import com.chen.util.LogUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainPresenter : BasePresenter<BaseView>() {


    fun requestTodayFromNet() {
        // When activity destroy, it will dispose itself
        mCompositeDisposable.add(
                ApiClient.instance.build()
                        .today()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({ LogUtil.e(it.toString()) }, { t -> LogUtil.e(t.toString()) })
        )
    }
}