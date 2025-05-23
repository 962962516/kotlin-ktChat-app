package com.kotlin.ktchat.repository

import com.kotlin.ktchat.entity.GroupInfo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface GroupRepository : JpaRepository<GroupInfo, Long> {
    fun findByGroupId(groupId: String): GroupInfo?
    
    fun findByGroupCode(groupCode: String): GroupInfo?
    
    @Query("SELECT g FROM GroupInfo g JOIN UserContact uc ON g.id = uc.contactId WHERE uc.userId = :userId AND uc.contactType = 2")
    fun findGroupByUserId(@Param("userId") userId: Long): List<GroupInfo>
    
    @Query("SELECT COUNT(g) FROM GroupInfo g WHERE g.groupOwnerId = :userId")
    fun selectGroupCountByUserId(@Param("userId") userId: Long): Long?
}