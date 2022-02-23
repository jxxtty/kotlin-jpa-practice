package com.example.kotlinjpapractice.repository

import com.example.kotlinjpapractice.model.entity.CustomerUser
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerUserRepository : JpaRepository<CustomerUser, Long> {

    fun existsByLoginId(loginId: String): Boolean
}