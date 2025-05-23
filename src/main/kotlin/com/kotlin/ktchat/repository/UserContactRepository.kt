package com.kotlin.ktchat.repository

import com.kotlin.ktchat.entity.UserContact
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface UserContactRepository : JpaRepository<UserContact, Long> {
    fun findByUserIdAndContactIdAndContactType(userId: Long, contactId: Long, contactType: Int): UserContact?
    
    @Query("SELECT uc FROM UserContact uc WHERE uc.userId = :userId AND uc.contactType = :contactType")
    fun findByUserIdAndContactType(@Param("userId") userId: Long, @Param("contactType") contactType: Int): List<UserContact>
    
    @Query("SELECT uc FROM UserContact uc WHERE uc.contactId = :contactId AND uc.contactType = :contactType")
    fun findByContactIdAndContactType(@Param("contactId") contactId: Long, @Param("contactType") contactType: Int): List<UserContact>
}