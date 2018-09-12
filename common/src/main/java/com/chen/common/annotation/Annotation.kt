package com.chen.common.annotation

import kotlin.reflect.KClass


@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class CreatePresenter(val kClass: Array<KClass<*>>)


@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class PresenterVariable