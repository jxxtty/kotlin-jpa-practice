package com.example.kotlinjpapractice.service

import com.example.kotlinjpapractice.model.entity.ShoppingMall
import com.example.kotlinjpapractice.repository.ShoppingMallRepository
import org.springframework.stereotype.Service

@Service
class ShoppingMallService(val shoppingMallRepository: ShoppingMallRepository) {

    fun createShoppingMall(shoppingMall: ShoppingMall) {
        shoppingMallRepository.save(shoppingMall)
    }
}