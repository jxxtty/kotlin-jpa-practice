package com.example.kotlinjpapractice.service

import com.example.kotlinjpapractice.model.entity.ShoppingMall
import com.example.kotlinjpapractice.repository.ShoppingMallRepository
import org.springframework.stereotype.Service

@Service
class ShoppingMallService(val shoppingMallRepository: ShoppingMallRepository) {

    fun existsById(shopId: Long): Boolean {
        return shoppingMallRepository.existsById(shopId)
    }

    fun createShoppingMall(shoppingMall: ShoppingMall) {
        shoppingMallRepository.save(shoppingMall)
    }

    fun findByIdReturnEntity(shopId: Long): ShoppingMall {
        return shoppingMallRepository.findById(shopId).get()
    }

    fun findByBizUserIdReturnEntity(bizUserId: Long): ShoppingMall {
        return shoppingMallRepository.findByBusinessUserId(bizUserId)?:throw Exception("can not find shopping mall")
    }
}