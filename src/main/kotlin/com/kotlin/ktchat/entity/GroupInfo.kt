package com.kotlin.ktchat.entity

import javax.persistence.*

@Entity
@Table(name = "group_info")
data class GroupInfo(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0L,
    val groupId: String,
    val groupCode: String,
    val groupName: String,
    val groupOwnerId: Long,
    val createTime: String,
    val groupNotice: String? = null,
    val joinType: Int,
    val status: Int
)