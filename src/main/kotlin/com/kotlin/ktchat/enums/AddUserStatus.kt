package com.kotlin.ktchat.enums

enum class AddUserStatus(val code: Int, val desc: String) {
    NORMAL(1, "正常"),
    BLACK(2, "拉黑"),
    DELETE(3, "删除")
}