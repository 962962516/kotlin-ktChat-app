package com.kotlin.ktchat.utils

import java.util.*

object UuIdUtils {
    fun generateUniqueId(): String {
        return UUID.randomUUID().toString().replace("-", "")
    }
}