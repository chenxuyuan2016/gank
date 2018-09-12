package com.chen.common.base.presenter

import android.app.Activity
import android.support.v4.app.Fragment
import com.chen.common.annotation.CreatePresenter
import com.chen.common.annotation.PresenterVariable

class PresenterProviders private constructor(private var activity: Activity?,
                                             private var v4Fragment: Fragment?,
                                             private var fragment: android.app.Fragment?) {

    private var presenterStore = PresenterStore()

    private var clazz: Class<*> = when {
        activity != null -> activity!!::class.java
        fragment != null -> fragment!!::class.java
        v4Fragment != null -> v4Fragment!!::class.java
        else -> throw Exception("I have no idea, what kind is this.")
    }

    init {
        resolveCreatePresenter()
        resolvePresenterVariable()
    }

    companion object {
        fun <T> inject(t: T): PresenterProviders {
            return PresenterProviders(t as? Activity, t as? Fragment, t as? android.app.Fragment)
        }
    }

    private fun resolveCreatePresenter() {
        clazz.getAnnotation(CreatePresenter::class.java)?.kClass?.forEach {
            presenterStore.put(it.java.canonicalName, it.java.newInstance() as Presenter)
        }
    }

    private fun resolvePresenterVariable() {
        clazz.declaredFields.forEach {
            it.declaredAnnotations.let {
                if (it.isEmpty() || it[0] !is PresenterVariable) return@forEach
            }
            presenterStore.get(it.type.name)?.run {
                it.isAccessible = true
                when {
                    activity != null -> it.set(activity, this)
                    fragment != null -> it.set(fragment, this)
                    else -> it.set(v4Fragment, this)
                }
            }

        }
    }

    fun getPresenterStore() = presenterStore

}

