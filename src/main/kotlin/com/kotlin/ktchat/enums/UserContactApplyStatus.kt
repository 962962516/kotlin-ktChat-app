package com.kotlin.ktchat.enums

enum class UserContactApplyStatus(val code: Int, val desc: String) {
    PENDING(1, "待处理"),
    ACCEPTED(2, "已接受"),
    REJECTED(3, "已拒绝")
}