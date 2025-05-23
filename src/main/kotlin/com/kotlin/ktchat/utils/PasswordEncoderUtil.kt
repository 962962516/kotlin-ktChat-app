package com.kotlin.ktchat.utils

import java.security.MessageDigest
import java.util.*

object PasswordEncoderUtil {
    fun encode(password: String): String {
        val md = MessageDigest.getInstance("SHA-256")
        val digest = md.digest(password.toByteArray())
        return Base64.getEncoder().encodeToString(digest)
    }
    
    fun matches(rawPassword: String, encodedPassword: String): Boolean {
        return encode(rawPassword) == encodedPassword
    }
}