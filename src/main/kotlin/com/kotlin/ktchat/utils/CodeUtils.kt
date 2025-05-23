package com.kotlin.ktchat.utils

import java.util.*

object CodeUtils {
    private const val USER_PREFIX = "U"
    private const val GROUP_PREFIX = "G"
    
    fun generateCode(type: Int): String {
        val random = Random()
        val randomNum = random.nextInt(900000) + 100000 // 生成6位随机数
        
        return when (type) {
            1 -> "$USER_PREFIX$randomNum"
            2 -> "$GROUP_PREFIX$randomNum"
            else -> randomNum.toString()
        }
    }
}