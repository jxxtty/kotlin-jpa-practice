package com.example.kotlinjpapractice.service

import com.example.kotlinjpapractice.model.entity.BusinessUser
import com.example.kotlinjpapractice.repository.BusinessUserRepository
import org.springframework.stereotype.Service

@Service
class BusinessUserService(val businessUserRepository: BusinessUserRepository) {

    fun existUserId(userId: Long): Boolean {
        return businessUserRepository.existsById(userId)
    }

    fun existLoginId(loginId: String): Boolean {
        return businessUserRepository.existsByLoginId(loginId)
    }

    fun findByIdReturnEntity(userId: Long): BusinessUser {
        return businessUserRepository.findById(userId).get()
    }

    fun createNewBusinessUser(newBizUser: BusinessUser) {
        businessUserRepository.save(newBizUser)
    }
}