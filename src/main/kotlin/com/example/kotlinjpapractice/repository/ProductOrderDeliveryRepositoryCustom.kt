package com.example.kotlinjpapractice.repository

import com.example.kotlinjpapractice.model.dto.order.OrderProductListRes
import com.example.kotlinjpapractice.model.dto.order.OrderRes

interface ProductOrderDeliveryRepositoryCustom {

    fun findOrderProductList(orderDeliveryId: Long): List<OrderProductListRes>


    fun findOrderAll(orderDeliveryId:Long, customerId: Long): OrderRes?
}