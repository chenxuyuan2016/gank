package com.chen.common.base.presenter

class PresenterStore {

    private var hashMap = HashMap<String, Presenter>()

    fun put(key: String, value: Presenter) = with(hashMap) {
        this[key] = value
    }

    fun get(key: String) = hashMap[key]

    fun clear() = with(hashMap) {
        forEach {
            it.value.onDestroy()
        }
        clear()
    }

    fun size() = hashMap.size

    fun getMap() = hashMap
}