package com.kotlin.ktchat.enums

enum class GroupStatus(val code: Int, val desc: String) {
    NORMAL(1, "正常"),
    DISBANDED(2, "已解散")
}