package com.example.kotlinjpapractice.repository

import com.example.kotlinjpapractice.model.dto.order.BizOrderListRes
import com.example.kotlinjpapractice.model.dto.order.OrderProductListRes
import com.example.kotlinjpapractice.model.dto.order.CustomerOrderRes

interface ProductOrderDeliveryRepositoryCustom {

    // for Customer
    fun findOrderProductList(orderDeliveryId: Long): List<OrderProductListRes>

    fun findOrderAllForCustomer(orderDeliveryId:Long, customerId: Long): CustomerOrderRes?


    // for Biz User
    fun findOrderListForBizUser(shopId: Long): List<BizOrderListRes>
}