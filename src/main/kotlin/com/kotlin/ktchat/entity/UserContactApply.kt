package com.kotlin.ktchat.entity

import javax.persistence.*

@Entity
@Table(name = "user_contact_apply")
data class UserContactApply(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0L,
    val userId: Long,
    val contactId: Long,
    val contactType: Int,
    val applyTime: String,
    val applyReason: String? = null,
    val status: Int
)