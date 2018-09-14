package com.chen.network.bean

import java.util.*

class BaseModel<T>(var category: Array<String>?, var error: Boolean?, var results: T?) {
    override fun toString(): String {
        return "BaseModel(category=${Arrays.toString(category)}, error=$error, results=$results)"
    }
}