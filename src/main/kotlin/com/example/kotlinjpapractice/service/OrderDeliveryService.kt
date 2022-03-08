package com.example.kotlinjpapractice.service

import com.example.kotlinjpapractice.model.dto.order.BizOrderDetailRes
import com.example.kotlinjpapractice.model.dto.order.BizOrderListRes
import com.example.kotlinjpapractice.model.dto.order.OrderProductListRes
import com.example.kotlinjpapractice.model.dto.order.CustomerOrderRes
import com.example.kotlinjpapractice.model.entity.OrderDelivery
import com.example.kotlinjpapractice.model.entity.ProductOrderDelivery
import com.example.kotlinjpapractice.repository.OrderDeliveryRepository
import com.example.kotlinjpapractice.repository.ProductOrderDeliveryRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OrderDeliveryService(
    val orderDeliveryRepository: OrderDeliveryRepository ,
    val productOrderDeliveryRepository: ProductOrderDeliveryRepository,

) {

    fun existsOrderDelivery(orderDeliveryId: Long): Boolean {
        return orderDeliveryRepository.existsById(orderDeliveryId)
    }

    fun findByIdReturnOrderDelivery(orderDeliveryId: Long): OrderDelivery {
        return orderDeliveryRepository.findById(orderDeliveryId).get()
    }

    fun findByOrderNum(orderNum: String): OrderDelivery {
        return orderDeliveryRepository.findByOrderNum(orderNum)?:throw Exception("cannot find orderDelivery")
    }

    fun findOrderAll(orderDeliveryId: Long, customerId: Long): CustomerOrderRes? {
        return productOrderDeliveryRepository.findOrderAllForCustomer(orderDeliveryId, customerId)
    }

    fun findOrderProductList(orderDeliveryId: Long): List<OrderProductListRes> {
        return productOrderDeliveryRepository.findOrderProductList(orderDeliveryId)
    }

    fun findOrderListForBizUser(shopId: Long): List<BizOrderListRes> {
        return productOrderDeliveryRepository.findOrderListForBizUser(shopId)
    }


    fun findOrderProductListForBizUser(orderNum: String): List<OrderProductListRes> {
        return productOrderDeliveryRepository.findOrderProductListForBizUser(orderNum).ifEmpty {
            throw Exception("can not find order Product List (for BizUser)")
        }
    }

    fun findOrderDetailForBizUser(orderNum: String): BizOrderDetailRes {
        return productOrderDeliveryRepository.findOrderDetailForBizUser(orderNum)?:throw Exception("can not find order detail (for BizUser)")
    }


    fun createOrder(orderDelivery: OrderDelivery) {
        orderDeliveryRepository.save(orderDelivery)
    }

    fun createProductOrderDelivery(productOrderDelivery: ProductOrderDelivery) {
        productOrderDeliveryRepository.save(productOrderDelivery)
    }

    @Transactional
    fun sendProduct(orderDelivery: OrderDelivery) {
        orderDelivery.sendProduct()
    }

    @Transactional
    fun deliveryProduct(orderDelivery: OrderDelivery) {
        orderDelivery.deliveryProduct()
    }


}