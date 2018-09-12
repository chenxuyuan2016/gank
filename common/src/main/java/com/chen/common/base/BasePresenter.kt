package com.chen.common.base

import com.chen.common.base.presenter.Presenter
import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<T : BaseView> : Presenter {

    var mCompositeDisposable = CompositeDisposable()

    var mView: T? = null

    override fun <V : BaseView> onCreate(v: V) {
        this.mView = v as T
    }

    override fun onDestroy() = mCompositeDisposable.dispose()

}