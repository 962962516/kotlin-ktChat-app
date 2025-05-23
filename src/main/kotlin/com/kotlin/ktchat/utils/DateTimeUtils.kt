package com.kotlin.ktchat.utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object DateTimeUtils {
    val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    
    fun formatDateTime(dateTime: LocalDateTime): String {
        return dateTime.format(formatter)
    }
    
    fun parseDateTime(dateTimeStr: String): LocalDateTime {
        return LocalDateTime.parse(dateTimeStr, formatter)
    }
    
    fun getCurrentDateTime(): String {
        return LocalDateTime.now().format(formatter)
    }
}