package com.kotlin.ktchat.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.kotlin.ktchat.utils.DateTimeUtils
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.*

@Table(
    name = "user_info",
    indexes = [
        Index(columnList = "email"),
        Index(columnList = "email, password"),
    ]
)
@Entity
data class User(
        @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val userId: Long = 0L,
        @Column(nullable = false) val username: String,
        @Column(unique = true, nullable = true)
    val email: String? = null,
        val userCode: String? = null,
        @JsonIgnore
    val password: String? = null,
        val createTime: String = LocalDateTime.now().format(DateTimeUtils.formatter),
        val lastLoginTime: String? = null,
        @Column(nullable = false)
        val nickName: String? = null,
        val avatar: String? = null,
        val gender: Int? = null,
        val phone: String? = null,
        val signature: String? = null,
        val status: Int? = null
)