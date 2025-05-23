package com.kotlin.ktchat.entity

import javax.persistence.*

@Entity
@Table(name = "user_contact")
data class UserContact(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0L,
    val userId: Long,
    val contactId: Long,
    val contactType: Int,
    val createTime: String,
    val remark: String? = null,
    val status: Int
)