package com.kotlin.ktchat.repository

import com.kotlin.ktchat.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findByEmail(email: String): User?
    
    fun findByUserCode(userCode: String): User?
    
    fun findByUsername(username: String): User?
}