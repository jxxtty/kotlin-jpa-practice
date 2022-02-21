package com.example.kotlinjpapractice.model.entity

import com.example.kotlinjpapractice.model.entity.enums.OrderStatus
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated

@Entity
class OrderDelivery(
    val orderNum: String,

    @Enumerated(EnumType.STRING)
    var orderStatus: OrderStatus,

    val sendDate: LocalDateTime?,

    val deliveryDate: LocalDateTime?
) : AutoEntity() {
}