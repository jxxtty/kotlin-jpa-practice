package com.example.kotlinjpapractice.service

import com.example.kotlinjpapractice.model.entity.BusinessUser
import com.example.kotlinjpapractice.repository.BusinessUserRepository
import org.springframework.stereotype.Service

@Service
class BusinessUserService(val businessUserRepository: BusinessUserRepository) {

    fun existLoginId(loginId: String): Boolean {
        return businessUserRepository.existsByLoginId(loginId)
    }

    fun createNewBusinessUser(newBizUser: BusinessUser) {
        businessUserRepository.save(newBizUser)
    }
}