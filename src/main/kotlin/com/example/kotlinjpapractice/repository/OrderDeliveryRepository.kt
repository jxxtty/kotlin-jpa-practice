package com.example.kotlinjpapractice.repository

import com.example.kotlinjpapractice.model.entity.OrderDelivery
import org.springframework.data.jpa.repository.JpaRepository

interface OrderDeliveryRepository  : JpaRepository<OrderDelivery, Long>{

    fun findByOrderNum(orderNum: String): OrderDelivery?
}