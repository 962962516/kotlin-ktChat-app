package com.kotlin.ktchat.execption

import com.kotlin.ktchat.enums.RestErrorCode

class BusinessException(val errorCode: RestErrorCode) : RuntimeException(errorCode.message) {
    val code: Int = errorCode.code
}