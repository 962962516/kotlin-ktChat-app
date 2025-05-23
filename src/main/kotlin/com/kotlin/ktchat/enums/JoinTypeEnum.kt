package com.kotlin.ktchat.enums

enum class JoinTypeEnum(val code: Int, val desc: String) {
    VERIFY(1, "需要验证"),
    DIRECT(2, "直接加入"),
    INVITE(3, "仅邀请加入")
}