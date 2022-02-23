package com.example.kotlinjpapractice.repository

import com.example.kotlinjpapractice.model.entity.ProductOrderDelivery
import org.springframework.data.jpa.repository.JpaRepository

interface ProductOrderDeliveryRepository : JpaRepository<ProductOrderDelivery, Long> {
}