package com.example.kotlinjpapractice.model.entity

import com.example.kotlinjpapractice.model.entity.enums.OrderStatus
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class OrderDelivery(
    val orderNum: String,

    @Enumerated(EnumType.STRING)
    var orderStatus: OrderStatus,

    val sendDate: LocalDateTime? = null,

    val deliveryDate: LocalDateTime? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    val customerUser: CustomerUser
) : AutoEntity() {
}