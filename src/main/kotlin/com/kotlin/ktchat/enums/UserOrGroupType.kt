package com.kotlin.ktchat.enums

enum class UserOrGroupType(val code: Int, val desc: String) {
    USER(1, "用户"),
    GROUP(2, "群组")
}