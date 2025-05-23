package com.kotlin.ktchat.enums

enum class RestErrorCode(val code: Int, val message: String) {
    SUCCESS(200, "成功"),
    PARAM_ERROR(400, "参数错误"),
    UNAUTHORIZED(401, "未授权"),
    FORBIDDEN(403, "禁止访问"),
    NOT_FOUND(404, "资源不存在"),
    METHOD_NOT_ALLOWED(405, "方法不允许"),
    CONFLICT(409, "资源冲突"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),
    SERVICE_UNAVAILABLE(503, "服务不可用"),
    
    // 用户相关错误码
    USER_NOT_EXIST(1001, "用户不存在"),
    USER_PASSWORD_ERROR(1002, "密码错误"),
    USER_ACCOUNT_LOCKED(1003, "账号已锁定"),
    USER_ACCOUNT_DISABLED(1004, "账号已禁用"),
    USER_ACCOUNT_EXPIRED(1005, "账号已过期"),
    USER_ACCOUNT_CREDENTIALS_EXPIRED(1006, "凭证已过期"),
    USER_ALREADY_EXIST(1007, "用户已存在"),
    
    // 群组相关错误码
    GROUP_NOT_EXIST(2001, "群组不存在"),
    GROUP_ALREADY_EXIST(2002, "群组已存在"),
    GROUP_MEMBER_NOT_EXIST(2003, "群成员不存在"),
    GROUP_MEMBER_ALREADY_EXIST(2004, "群成员已存在"),
    GROUP_OWNER_CANNOT_LEAVE(2005, "群主不能退出群组"),
    GROUP_COUNT_MANY(2006, "群组数量已达上限")
}