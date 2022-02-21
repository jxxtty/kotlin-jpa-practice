package com.example.kotlinjpapractice.repository

import com.example.kotlinjpapractice.model.entity.BusinessUser
import org.springframework.data.jpa.repository.JpaRepository

interface BusinessUserRepository : JpaRepository<BusinessUser, Long> {
    fun existsByLoginId(loginId: String): Boolean
}