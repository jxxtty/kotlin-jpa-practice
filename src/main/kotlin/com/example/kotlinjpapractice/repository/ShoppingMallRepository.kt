package com.example.kotlinjpapractice.repository

import com.example.kotlinjpapractice.model.entity.ShoppingMall
import org.springframework.data.jpa.repository.JpaRepository

interface ShoppingMallRepository : JpaRepository<ShoppingMall, Long> {
}