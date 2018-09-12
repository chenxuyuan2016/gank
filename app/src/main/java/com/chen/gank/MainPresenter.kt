package com.chen.gank

import com.chen.common.base.BasePresenter
import com.chen.common.base.BaseView
import io.reactivex.Flowable

class MainPresenter : BasePresenter<BaseView>() {


    fun test() {
        // When activity destroy, it will dispose itself
        mCompositeDisposable.add(
                Flowable.just("test from MainPresenter")
                        .subscribe({ mView?.toast(it) })
        )
    }
}