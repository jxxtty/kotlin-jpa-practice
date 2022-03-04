package com.example.kotlinjpapractice.service

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
        return orderDeliveryRepository.findByOrderNum(orderNum).let {
            if(it == null) throw Exception("cannot find orderDelivery")
            else it!!
        }
    }

    fun findOrderAll(orderDeliveryId: Long, customerId: Long): CustomerOrderRes? {
        return productOrderDeliveryRepository.findOrderAllForCustomer(orderDeliveryId, customerId)
    }

    fun findOrderProductList(orderDeliveryId: Long): List<OrderProductListRes> {
        return productOrderDeliveryRepository.findOrderProductList(orderDeliveryId)
    }

    fun findOrderListForBizUser(bizUserId: Long): List<BizOrderListRes> {
        TODO()
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