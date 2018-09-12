package com.chen.common.base.presenter

import android.support.v4.app.Fragment
import com.chen.common.annotation.CreatePresenter
import com.chen.common.annotation.PresenterVariable
import com.chen.common.base.BaseActivity

class PresenterProviders private constructor(activity: BaseActivity?, fragment: Fragment?) {

    private var presenterStore = PresenterStore()
    private var fragment: Fragment? = null
    private var activity: BaseActivity? = null
    private lateinit var clazz: Class<*>

    init {
        if (activity != null) {
            this.activity = activity
            clazz = activity::class.java
        }
        if (fragment != null) {
            this.fragment = fragment
            clazz = fragment::class.java
        }
        resolveCreatePresenter()
        resolvePresenterVariable()
    }

    companion object {
        fun inject(activity: BaseActivity) = PresenterProviders(activity, null)
        fun inject(fragment: Fragment) = PresenterProviders(null, fragment)
    }


    private fun resolveCreatePresenter() {
        val createPresenter = clazz.getAnnotation(CreatePresenter::class.java)
        if (createPresenter != null) {
            val kClass = createPresenter.kClass
            kClass.iterator().forEach {
                try {
                    presenterStore.put(it.java.canonicalName, it.java.newInstance() as Presenter)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }


    private fun resolvePresenterVariable() {
        clazz.declaredFields.iterator().forEach {
            val annotations = it.declaredAnnotations
            if (!annotations.isEmpty()) {
                if (annotations[0] is PresenterVariable) {
                    val instant = presenterStore.get(it.type.name)
                    if (instant != null) {
                        try {
                            it.isAccessible = true
                            it.set(if (activity == null) fragment else activity, instant)
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                }
            }
        }
    }

    fun getPresenterStore() = presenterStore

}

