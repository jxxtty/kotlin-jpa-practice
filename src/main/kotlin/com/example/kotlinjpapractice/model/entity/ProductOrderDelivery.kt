package com.example.kotlinjpapractice.model.entity

import java.time.LocalDateTime
import javax.persistence.*

@Entity
class ProductOrderDelivery(

    @ManyToOne
    @JoinColumn(name = "product_id")
    var product: Product,

    @ManyToOne
    @JoinColumn(name = "order_delivery_id")
    var orderDelivery: OrderDelivery,

    var orderAmount: Int,

    val orderDate: LocalDateTime = LocalDateTime.now()
) : AutoEntity() {


}