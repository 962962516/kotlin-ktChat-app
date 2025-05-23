package com.kotlin.ktchat.utils

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*

@Component
class TokenUtil {
    @Value("\${token.privateKey}")
    private lateinit var privateKey: String
    
    @Value("\${token.validTime}")
    private var validTime: Long = 0
    
    fun generateToken(userId: Long): String {
        val claims = HashMap<String, Any>()
        claims["userId"] = userId
        
        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + validTime))
            .signWith(SignatureAlgorithm.HS256, privateKey)
            .compact()
    }
    
    fun validateToken(token: String): Boolean {
        try {
            val claims = getClaimsFromToken(token)
            val expiration = claims.expiration
            return expiration.after(Date())
        } catch (e: Exception) {
            return false
        }
    }
    
    fun getUserIdFromToken(token: String): Long? {
        try {
            val claims = getClaimsFromToken(token)
            return claims.get("userId", Long::class.java)
        } catch (e: Exception) {
            return null
        }
    }
    
    private fun getClaimsFromToken(token: String): Claims {
        return Jwts.parser()
            .setSigningKey(privateKey)
            .parseClaimsJws(token)
            .body
    }
}