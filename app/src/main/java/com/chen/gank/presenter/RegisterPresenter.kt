package com.chen.gank.presenter

import com.chen.common.base.BasePresenter
import com.chen.gank.MyApplication
import com.chen.gank.login.RegisterView
import com.chen.util.SPUtil
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class RegisterPresenter : BasePresenter<RegisterView>() {

    private var username by SPUtil(MyApplication.instance, "username", "")
    private var pwd by SPUtil(MyApplication.instance, "pwd", "")

    fun register() {
        username = "kconn"
        pwd = "123456"
        mView?.toast("注册成功，正在登陆")
        mCompositeDisposable.add(
                Flowable.interval(3, 1, TimeUnit.SECONDS)
                        .take(1)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            mView?.registerSuccess()
                        })
        )


    }

}