package com.kotlin.ktchat.api.bean.response

import com.kotlin.ktchat.enums.RestErrorCode

data class ApiResponse<T>(
    val code: Int,
    val message: String,
    val data: T? = null
) {
    companion object {
        fun <T> success(data: T? = null): ApiResponse<T> {
            return ApiResponse(RestErrorCode.SUCCESS.code, RestErrorCode.SUCCESS.message, data)
        }
        
        fun <T> error(errorCode: RestErrorCode, data: T? = null): ApiResponse<T> {
            return ApiResponse(errorCode.code, errorCode.message, data)
        }
        
        fun <T> error(code: Int, message: String, data: T? = null): ApiResponse<T> {
            return ApiResponse(code, message, data)
        }
    }
}