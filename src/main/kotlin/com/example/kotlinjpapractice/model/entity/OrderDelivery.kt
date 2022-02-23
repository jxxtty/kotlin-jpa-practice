package com.example.kotlinjpapractice.model.entity

import com.example.kotlinjpapractice.model.entity.enums.OrderStatus
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class OrderDelivery(
    val orderNum: String,

    @Enumerated(EnumType.STRING)
    var orderStatus: OrderStatus,

    var sendDate: LocalDateTime? = null,

    var deliveryDate: LocalDateTime? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    val customerUser: CustomerUser
) : AutoEntity() {

    fun sendProduct() {
        this.sendDate = LocalDateTime.now()
        this.orderStatus = OrderStatus.FINISH_SEND
    }

    fun deliveryProduct() {
        this.deliveryDate = LocalDateTime.now()
        this.orderStatus = OrderStatus.FINISH_DELIVERY
    }
}