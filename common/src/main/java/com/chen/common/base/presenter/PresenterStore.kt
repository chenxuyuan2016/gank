package com.chen.common.base.presenter

class PresenterStore {

    private var hashMap = HashMap<String, Presenter>()

    fun put(key: String, value: Presenter) {
        hashMap[key] = value
    }

    fun get(key: String) = hashMap[key]

    fun clear() {
        hashMap.forEach {
            it.value.onDestroy()
        }
        hashMap.clear()
    }

    fun size() = hashMap.size

    fun getMap() = hashMap
}