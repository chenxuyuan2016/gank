package com.chen.common.base.presenter

import android.app.Activity
import android.support.v4.app.Fragment
import com.chen.common.annotation.PresenterCreate
import com.chen.common.annotation.PresenterSet
import com.chen.common.base.BaseView

class PresenterProviders private constructor(private var activity: Activity?,
                                             private var v4Fragment: Fragment?,
                                             private var fragment: android.app.Fragment?) {


    private var hashMap = HashMap<String, Presenter>()

    private var clazz: Class<*> = when {
        activity != null -> activity!!::class.java
        fragment != null -> fragment!!::class.java
        v4Fragment != null -> v4Fragment!!::class.java
        else -> throw Exception("I have no idea, what kind is this.")
    }

    init {
        createPresenter()
        setPresenter()
    }

    companion object {
        fun <T> inject(t: T): PresenterProviders {
            return PresenterProviders(t as? Activity, t as? Fragment, t as? android.app.Fragment)
        }
    }

    private fun createPresenter() {
        clazz.getAnnotation(PresenterCreate::class.java)?.kClass?.forEach {
            hashMap[it.java.canonicalName] = it.java.newInstance() as Presenter
        }
    }

    private fun setPresenter() {
        clazz.declaredFields.forEach {
            it.declaredAnnotations.let {
                if (it.isEmpty() || it[0] !is PresenterSet) return@forEach
            }
            hashMap[it.type.name]?.run {
                it.isAccessible = true
                when {
                    activity != null -> it.set(activity, this)
                    fragment != null -> it.set(fragment, this)
                    else -> it.set(v4Fragment, this)
                }
            }

        }
    }


    fun <V : BaseView> onPresenterCreate(v: V) = hashMap.forEach { it.value.onCreate(v) }

    fun onPresenterDestroy() = with(hashMap) {
        forEach { it.value.onDestroy() }
        clear()
    }

}

