package com.example.kotlinjpapractice.service

import com.example.kotlinjpapractice.model.entity.BusinessUser
import com.example.kotlinjpapractice.model.entity.CustomerUser
import com.example.kotlinjpapractice.repository.BusinessUserRepository
import com.example.kotlinjpapractice.repository.CustomerUserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    val businessUserRepository: BusinessUserRepository,
    val customerUserRepository: CustomerUserRepository
    ) {

    fun existsBizUserId(userId: Long): Boolean {
        return businessUserRepository.existsById(userId)
    }

    fun existsBizLoginId(loginId: String): Boolean {
        return businessUserRepository.existsByLoginId(loginId)
    }

    fun findByIdReturnBizUser(userId: Long): BusinessUser {
        return businessUserRepository.findById(userId).get()
    }

    fun findByIdReturnCustomerUser(userId: Long): CustomerUser {
        return customerUserRepository.findById(userId).get()
    }

    fun createNewBusinessUser(newBizUser: BusinessUser) {
        businessUserRepository.save(newBizUser)
    }

    fun existsCustomerUserId(userId: Long): Boolean {
        return customerUserRepository.existsById(userId)
    }

    fun existsCustomerLoginId(loginId: String): Boolean {
        return customerUserRepository.existsByLoginId(loginId)
    }

    fun createNewCustomerUser(newCustomerUser: CustomerUser) {
        customerUserRepository.save(newCustomerUser)
    }
}