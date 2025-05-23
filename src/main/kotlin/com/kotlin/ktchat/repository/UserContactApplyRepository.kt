package com.kotlin.ktchat.repository

import com.kotlin.ktchat.entity.UserContactApply
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface UserContactApplyRepository : JpaRepository<UserContactApply, Long> {
    fun findByUserIdAndContactIdAndContactType(userId: Long, contactId: Long, contactType: Int): UserContactApply?
    
    @Query("SELECT uca FROM UserContactApply uca WHERE uca.contactId = :contactId AND uca.contactType = :contactType AND uca.status = :status")
    fun findByContactIdAndContactTypeAndStatus(
        @Param("contactId") contactId: Long,
        @Param("contactType") contactType: Int,
        @Param("status") status: Int
    ): List<UserContactApply>
    
    @Query("SELECT uca FROM UserContactApply uca WHERE uca.userId = :userId AND uca.status = :status")
    fun findByUserIdAndStatus(
        @Param("userId") userId: Long,
        @Param("status") status: Int
    ): List<UserContactApply>
}