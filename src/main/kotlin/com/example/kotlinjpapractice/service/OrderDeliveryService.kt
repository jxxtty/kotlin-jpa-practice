package com.example.kotlinjpapractice.service

import com.example.kotlinjpapractice.model.entity.CustomerUser
import com.example.kotlinjpapractice.model.entity.OrderDelivery
import com.example.kotlinjpapractice.model.entity.ProductOrderDelivery
import com.example.kotlinjpapractice.repository.OrderDeliveryRepository
import com.example.kotlinjpapractice.repository.ProductOrderDeliveryRepository
import com.example.kotlinjpapractice.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class OrderDeliveryService(
    val orderDeliveryRepository: OrderDeliveryRepository ,
    val productOrderDeliveryRepository: ProductOrderDeliveryRepository,

) {

    fun createOrder(orderDelivery: OrderDelivery) {
        orderDeliveryRepository.save(orderDelivery)
    }

    fun createProductOrderDelivery(productOrderDelivery: ProductOrderDelivery) {
        productOrderDeliveryRepository.save(productOrderDelivery)
    }


}